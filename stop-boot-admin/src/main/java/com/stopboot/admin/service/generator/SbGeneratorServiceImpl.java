package com.stopboot.admin.service.generator;

import cn.hutool.core.util.StrUtil;
import com.stopboot.admin.annotation.SbDataSource;
import com.stopboot.admin.config.DataSourceEnum;
import com.stopboot.admin.config.GeneratorConfig;
import com.stopboot.admin.dto.MenuInfo;
import com.stopboot.admin.service.system.menu.MenuServiceI;
import com.stopboot.admin.service.system.permission.PermissionServiceI;
import com.stopboot.admin.strategy.generator.SbGeneratorStrategyContext;
import com.stopboot.admin.strategy.generator.SbGeneratorStrategyParams;
import com.stopboot.admin.strategy.generator.impl.admin.SbAdminGeneratorStrategyImpl;
import com.stopboot.admin.strategy.generator.impl.sdk.js.SbJsGeneratorStrategyImpl;
import com.stopboot.admin.strategy.generator.impl.ui.SbUiGeneratorStrategyImpl;
import com.stopboot.admin.mapper.custom.help.StopBootTableMapper;
import com.stopboot.admin.model.help.datasource.table.columns.TableColumnsParams;
import com.stopboot.admin.model.help.datasource.table.columns.TableColumnsVO;
import com.stopboot.admin.model.help.datasource.table.list.TableListVO;
import com.stopboot.admin.model.help.generator.GeneratorInfo;
import com.stopboot.admin.model.help.generator.dowm.ColumInfo;
import com.stopboot.admin.model.help.generator.dowm.GeneratorParams;
import com.stopboot.admin.model.help.generator.dowm.GeneratorVO;
import com.stopboot.admin.model.help.generator.pre.GeneratorPreParams;
import com.stopboot.admin.model.help.generator.pre.GeneratorPreVO;
import com.stopboot.admin.model.help.generator.pre.MenuInfoVO;
import com.stopboot.admin.model.help.generator.submit.GeneratorSubmitParams;
import com.stopboot.admin.model.help.generator.submit.GeneratorSubmitVO;
import com.stopboot.admin.utils.BeansHelper;
import com.stopboot.admin.utils.TypeConvertUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.File;
import java.util.*;


/**
 * @version:0.0.1
 * @author: Lianyutao
 * @create: 2019-10-23 10:01
 * @description: 生成后台逻辑代码
 **/

@Slf4j
@Service
public class SbGeneratorServiceImpl implements SbGeneratorServiceI {

    @Resource
    private MenuServiceI menuService;

    @Resource
    private SbGeneratorStrategyContext context;

    @Resource
    private GeneratorConfig generatorConfig;

    @Resource
    private StopBootTableMapper stopBootTableMapper;

    @Resource
    private SbJsGeneratorStrategyImpl sbJsGeneratorStrategy;

    @Resource
    private SbAdminGeneratorStrategyImpl sbAdminGeneratorStrategy;

    @Resource
    private SbUiGeneratorStrategyImpl sbUiGeneratorStrategy;

    @Resource
    private PermissionServiceI permissionService;


    @SbDataSource(DataSourceEnum.DB_MASTER)
    @Override
    public List<TableColumnsVO> getTableColumns(TableColumnsParams params) {
        List<TableColumnsVO> tableColumns = stopBootTableMapper.getTableColumns(params.getTableName());
        tableColumns.stream().forEach(tableColumnsVO -> {
            String toCamelCase = StrUtil.toCamelCase(tableColumnsVO.getColumnName());
            tableColumnsVO.setCamelColumnName(toCamelCase);
            tableColumnsVO.setRealType(TypeConvertUtil.mysqlTypeToJava(tableColumnsVO.getDataType()));
        });
        return tableColumns;
    }

    /**
     * 获得基本配置信息
     *
     * @param params
     * @return
     */
    @Override
    public GeneratorPreVO pre(GeneratorPreParams params) {
        //1.基本信息
        GeneratorPreVO generatorPreVO = (GeneratorPreVO) BeansHelper.getInstance().convert(generatorConfig, GeneratorPreVO.class);
        //菜单信息
        Integer menuId = params.getMenuId();
        MenuInfo menuInfo = menuService.getAllMenuInfoById(menuId);
        MenuInfoVO menuInfoVO = (MenuInfoVO) BeansHelper.getInstance().convert(menuInfo, MenuInfoVO.class);
        generatorPreVO.setMenuInfo(menuInfoVO);
        //获得数据库的全部表名
        List<TableListVO> tableList = this.getTableList();
        generatorPreVO.setTableList(tableList);
        //代码输出路径
        String templatePath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        templatePath = templatePath + "generator/";
        generatorPreVO.setDefaultGeneratorPath(templatePath);

        return generatorPreVO;
    }

    @SbDataSource(DataSourceEnum.DB_MASTER)
    private List<TableListVO> getTableList() {
        List<TableListVO> tableList = stopBootTableMapper.getTableList();
        return tableList;
    }


    @Override
    public GeneratorSubmitVO submit(GeneratorSubmitParams params) {
        GeneratorSubmitVO generatorSubmitVO = new GeneratorSubmitVO();
        GeneratorInfo generatorInfo = new GeneratorInfo();

        //基本信息
        generatorInfo.setDate(new Date());
        generatorInfo.setAuthor(params.getAuthor());
        generatorInfo.setProjectName(params.getProjectName());
        generatorInfo.setProjectDesc(params.getProjectDesc());
        generatorInfo.setVersion(params.getVersion());
        String generatorPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        generatorPath = generatorPath + "generator/";
        generatorInfo.setDefaultGeneratorPath(generatorPath);

        generatorInfo.setAdminPath(params.getAdminPath());
        generatorInfo.setSdkPath(params.getSdkPath());
        generatorInfo.setViewPath(params.getViewPath());

        //菜单信息
        MenuInfoVO menuInfo = params.getMenuInfo();
        Integer menuId = menuInfo.getId();

        generatorInfo.setPath(menuInfo.getPath());
        generatorInfo.setMenuId(menuId);
        generatorInfo.setMenuComponent(menuInfo.getComponent());
        generatorInfo.setTitle(menuInfo.getTitle());

        String fullPath = menuInfo.getFullPath();
        generatorInfo.setFullPath(fullPath);
        generatorInfo.setFullPathToPackage(fullPath.replaceAll("/", "."));

        generatorInfo.setModel(params.getMenuInfo().getName());

        generatorInfo.setJsSdkConfigPath(params.getJsSdkConfigPath());

        //其他配置
        String basePackage = params.getBasePackage();
        generatorInfo.setBasePackage(basePackage);

        String basePackageToPath = basePackage.replaceAll("\\.", "\\" + File.separator);
        generatorInfo.setBasePackageToPath(basePackageToPath);

        String entityPackage = params.getEntityPackage();
        generatorInfo.setEntityPackage(entityPackage);

        String entityExamplePackage = params.getEntityExamplePackage();
        generatorInfo.setEntityExamplePackage(entityExamplePackage);

        String entityMapperPackage = params.getEntityMapperPackage();
        generatorInfo.setEntityMapperPackage(entityMapperPackage);

        String tableName = StrUtil.toCamelCase(params.getSelectedTableName());
        generatorInfo.setTableName(tableName);

        generatorInfo.setTableColumnsData(params.getTableColumnsData());

        generatorInfo.setFullPathToPermission("P" + fullPath.replaceAll("/", "_").toUpperCase());

        //生成后端方法
        context.execute(new SbGeneratorStrategyParams(sbAdminGeneratorStrategy, generatorInfo));
        //生成后端UI接口策略
        context.execute(new SbGeneratorStrategyParams(sbJsGeneratorStrategy, generatorInfo));
        //生成后端view页面
        context.execute(new SbGeneratorStrategyParams(sbUiGeneratorStrategy, generatorInfo));

        generatorSubmitVO.setUrl(generatorPath);

        //默认认生成权限标签

        permissionService.addGeneratorPermission(generatorInfo);

        return generatorSubmitVO;
    }

    /**
     * 生成代码下载地址
     * <p>
     * 1、使用模板引擎生成各端代码
     * 2.将代码压缩保存到指定路径并返回对应的路径
     *
     * @return
     */
    @Override
    public GeneratorVO done(GeneratorParams params) {
        GeneratorVO generatorVO = new GeneratorVO();
        try {
            //代码片段
            String templatePath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
            templatePath = templatePath + "generator/";
            generatorVO.setUrl(templatePath);


            String basePackage1 = generatorConfig.getBasePackage();


            System.out.println("templatePath==========" + templatePath);
//            Integer menuId = params.getMenuId();
            //根据menuId获得menu信息(包含所有父节点)
            MenuInfo menuInfo = menuService.getAllMenuInfoById(19);

            List<ColumInfo> columsInfoList = new ArrayList<>();

            {
                ColumInfo columInfo = new ColumInfo();
                columInfo.setColumnName("id");
                columInfo.setColumnComment("id");
                columInfo.setDataType("int");
                columInfo.setNullable("YES");
                columInfo.setTitle("主键id");
                columsInfoList.add(columInfo);
            }

            {
                ColumInfo columInfo = new ColumInfo();
                columInfo.setColumnName("name");
                columInfo.setColumnComment("姓名");
                columInfo.setDataType("varchar");
                columInfo.setNullable("YES");

                columInfo.setTitle("姓名");
                columsInfoList.add(columInfo);
            }

            {
                ColumInfo columInfo = new ColumInfo();
                columInfo.setColumnName("age");
                columInfo.setColumnComment("年龄");
                columInfo.setDataType("int");
                columInfo.setNullable("NO");

                columInfo.setTitle("年龄");
                columsInfoList.add(columInfo);
            }


//            BaseInfo baseInfo = new BaseInfo();
//            baseInfo.setAuthor("lyt");
//            baseInfo.setTemplatePath(templatePath);
//            baseInfo.setViewPath(viewPath);
//            baseInfo.setFullPath(fullPath);
//            baseInfo.setHttpConfigPath(httpConfigPath);


        } catch (Exception e) {
            log.error(e.getMessage());
        }

        return generatorVO;
    }
}
