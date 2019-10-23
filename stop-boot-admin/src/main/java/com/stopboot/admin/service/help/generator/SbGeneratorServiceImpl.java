package com.stopboot.admin.service.help.generator;

import com.stopboot.admin.dto.MenuInfo;
import com.stopboot.admin.generator.SbGeneratorStrategyContext;
import com.stopboot.admin.generator.SbGeneratorStrategyParams;
import com.stopboot.admin.model.help.generator.BaseInfo;
import com.stopboot.admin.model.help.generator.dowm.ColumInfo;
import com.stopboot.admin.model.help.generator.dowm.GeneratorParams;
import com.stopboot.admin.model.help.generator.dowm.GeneratorVO;
import com.stopboot.admin.service.menu.MenuServiceI;
import com.stopboot.admin.utils.FreemarkerUtil;
import com.stopboot.admin.utils.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.File;
import java.io.StringWriter;
import java.util.*;


/**
 *
 */
@Slf4j
@Service
public class SbGeneratorServiceImpl implements SbGeneratorService {

    @Resource
    private MenuServiceI menuService;

    @Resource
    private SbGeneratorStrategyContext context;

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

            String entityMapperPackage = "com.stopboot.admin.dao.mybatis.mapper.SbTestMapper";
            map.put("entityMapperPackage", entityMapperPackage);
            map.put("entityMapperName", entityMapperPackage.substring(entityMapperPackage.lastIndexOf(".") + 1, entityMapperPackage.length()));


            List bizType = Arrays.asList("controller", "service", "serviceImpl", "params");
            List apiType = Arrays.asList("page", "one", "add", "update", "delete");
            List uiType = Arrays.asList("index", "create", "edit");


            //生成api接口
            for (Object type : apiType) {
                map.put("apiType", type);
                StringWriter writer = FreemarkerUtil.process("api/js/api.ftl", map);
                StringBuffer buffer = writer.getBuffer();
//                System.out.println("type" + type);
//                System.out.println("writer:\n" + writer);

                File packageDir = new File(templatePath, (httpConfigPath + fullPath + "/" + type.toString().replaceAll("\\.", "\\" + File.separator)));
                if (!packageDir.exists()) {
                    packageDir.mkdirs();
                }
                FileUtils.write(new File(packageDir, type + ".js"), writer.getBuffer());
            }
            //生成admin逻辑
            for (Object type : bizType) {
                map.put("bizType", type);

                if (type.toString().equals("serviceImpl")) {
                    StringWriter writer = FreemarkerUtil.process("admin/" + type + ".ftl", map);
                    System.out.println("writer:\n" + writer);

                    File packageDir = new File(templatePath, (basePackageToPath + "/" + type.toString().substring(0, type.toString().length() - 4).replaceAll("\\.", "\\" + File.separator)) + fullPath);
                    if (!packageDir.exists()) {
                        packageDir.mkdirs();
                    }
                    FileUtils.write(new File(packageDir, StringUtil.captureName(model) + StringUtil.captureName(type.toString()) + ".java"), writer.getBuffer());
                } else if (type.toString().equals("params")) {
                    for (Object t : apiType) {
                        map.put("bizParamsType", t);
                        {
                            StringWriter writer = FreemarkerUtil.process("admin/" + type + ".ftl", map);
                            StringBuffer buffer = writer.getBuffer();

                            File packageDir = new File(templatePath, (basePackageToPath + "/" + type.toString().replaceAll("\\.", "\\" + File.separator)) + fullPath + "/" + t.toString());
                            if (!packageDir.exists()) {
                                packageDir.mkdirs();
                            }
                            FileUtils.write(new File(packageDir, StringUtil.captureName(model) + StringUtil.captureName(t.toString()) + "Params.java"), writer.getBuffer());
                        }
                        if (t.toString().equals("page") || t.toString().equals("one")) {
                            {
                                StringWriter writer = FreemarkerUtil.process("admin/vo.ftl", map);
                                StringBuffer buffer = writer.getBuffer();

                                File packageDir = new File(templatePath, (basePackageToPath + "/" + type.toString().replaceAll("\\.", "\\" + File.separator)) + fullPath + "/" + t.toString());
                                if (!packageDir.exists()) {
                                    packageDir.mkdirs();
                                }
                                FileUtils.write(new File(packageDir, StringUtil.captureName(model) + StringUtil.captureName(t.toString()) + "VO.java"), writer.getBuffer());
                            }
                        }
                    }
                } else {
                    StringWriter writer = FreemarkerUtil.process("admin/" + type + ".ftl", map);
                    System.out.println("writer:\n" + writer);

                    File packageDir = new File(templatePath, (basePackageToPath + "/" + type.toString().replaceAll("\\.", "\\" + File.separator)) + fullPath + "/");
                    if (!packageDir.exists()) {
                        packageDir.mkdirs();
                    }
                    FileUtils.write(new File(packageDir, StringUtil.captureName(model) + StringUtil.captureName(type.toString()) + ".java"), writer.getBuffer());
                }

            }


            //生成admin逻辑
            for (Object type : uiType) {
                map.put("uiType", type);
                StringWriter writer = FreemarkerUtil.process("ui/vue/" + type + ".ftl", map);
                System.out.println("writer:\n" + writer);
                File packageDir = new File(templatePath, (viewPath + fullPath));
                if (!packageDir.exists()) {
                    packageDir.mkdirs();
                }
                FileUtils.write(new File(packageDir, type + ".vue"), writer.getBuffer());
            }

            BaseInfo baseInfo = new BaseInfo();
            Map<String, Object> data = new HashMap<>();
            //生成后端view页面
            context.execute(new SbGeneratorStrategyParams("ui", baseInfo, data));


        } catch (Exception e) {
            log.error(e.getMessage());
        }

        return generatorVO;
    }
}
