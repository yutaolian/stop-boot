package com.stopboot.admin.service.generator;

import com.stopboot.admin.annotation.SbDataSource;
import com.stopboot.admin.config.DataSourceEnum;
import com.stopboot.admin.config.GeneratorConfig;
import com.stopboot.admin.dto.MenuInfo;
import com.stopboot.admin.generator.SbGeneratorStrategyContext;
import com.stopboot.admin.generator.SbGeneratorStrategyParams;
import com.stopboot.admin.mapper.custom.help.StopBootTableMapper;
import com.stopboot.admin.model.help.datasource.table.columns.TableColumnsParams;
import com.stopboot.admin.model.help.datasource.table.columns.TableColumnsVO;
import com.stopboot.admin.model.help.datasource.table.list.TableListVO;
import com.stopboot.admin.model.help.generator.BaseInfo;
import com.stopboot.admin.model.help.generator.dowm.ColumInfo;
import com.stopboot.admin.model.help.generator.dowm.GeneratorParams;
import com.stopboot.admin.model.help.generator.dowm.GeneratorVO;
import com.stopboot.admin.model.help.generator.pre.GeneratorPreParams;
import com.stopboot.admin.model.help.generator.pre.GeneratorPreVO;
import com.stopboot.admin.model.help.generator.pre.MenuInfoVO;
import com.stopboot.admin.service.menu.MenuServiceI;
import com.stopboot.admin.utils.BeansHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.File;
import java.util.*;


/**
 * @author 91haoke
 */
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

    @SbDataSource(DataSourceEnum.DB_MASTER)
    @Override
    public List<TableListVO> getTableList() {
        List<TableListVO> tableList = stopBootTableMapper.getTableList();
        return tableList;
    }

    @SbDataSource(DataSourceEnum.DB_MASTER)
    @Override
    public List<TableColumnsVO> getTableColumns(TableColumnsParams params) {
        List<TableColumnsVO> tableColumns = stopBootTableMapper.getTableColumns(params.getTableName());
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
        return generatorPreVO;
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
            Integer menuId = params.getMenuId();
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


            Map<String, Object> map = new HashMap<>(10);


            map.put("author", "lyt");
            map.put("date", new Date());
            map.put("projectName", "");
            map.put("version", "1.0.1");
            map.put("desc", "描述");
            map.put("tableName", "sb_test");

            String basePackage = "com.stopboot.admin";
            String model = "test22";
            String httpConfigPath = "/sdk/api";
            String viewPath = "/views";
            String fullPath = "/test/test2/test22";

            map.put("basePackage", basePackage);
            map.put("model", model);
            map.put("path", fullPath);
            map.put("pathToPackage", fullPath.replaceAll("/", "."));
            map.put("httpConfigPath", httpConfigPath);
            map.put("columsInfoList", columsInfoList);

            String basePackageToPath = basePackage.replaceAll("\\.", "\\" + File.separator);
            map.put("basePackageToPath", basePackageToPath);

            String entityPackage = "com.stopboot.admin.entity.SbTest";
            map.put("entityPackage", entityPackage);
            map.put("entityName", entityPackage.substring(entityPackage.lastIndexOf(".") + 1, entityPackage.length()));

            String entityExamplePackage = "com.stopboot.admin.entity.SbTestExample";
            map.put("entityExamplePackage", entityExamplePackage);
            map.put("entityExampleName", entityExamplePackage.substring(entityExamplePackage.lastIndexOf(".") + 1, entityExamplePackage.length()));

            String entityMapperPackage = "com.stopboot.admin.mapper.mybatis.SbTestMapper";
            map.put("entityMapperPackage", entityMapperPackage);
            map.put("entityMapperName", entityMapperPackage.substring(entityMapperPackage.lastIndexOf(".") + 1, entityMapperPackage.length()));


            BaseInfo baseInfo = new BaseInfo();
            baseInfo.setAuthor("lyt");
            baseInfo.setTemplatePath(templatePath);
            baseInfo.setViewPath(viewPath);
            baseInfo.setFullPath(fullPath);
            baseInfo.setHttpConfigPath(httpConfigPath);

            //生成后端方法
            context.execute(new SbGeneratorStrategyParams("admin", baseInfo, map));
            //生成ui接口
            context.execute(new SbGeneratorStrategyParams("js", baseInfo, map));
            //生成后端view页面
            context.execute(new SbGeneratorStrategyParams("ui", baseInfo, map));

        } catch (Exception e) {
            log.error(e.getMessage());
        }

        return generatorVO;
    }
}
