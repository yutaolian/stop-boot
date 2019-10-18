package com.stopboot.admin.service.help.generator;

import com.stopboot.admin.dto.MenuInfo;
import com.stopboot.admin.model.help.generator.dowm.ColumInfo;
import com.stopboot.admin.model.help.generator.dowm.GeneratorParams;
import com.stopboot.admin.model.help.generator.dowm.GeneratorVO;
import com.stopboot.admin.service.menu.MenuServiceI;
import com.stopboot.admin.utils.FreemarkerUtil;
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
            map.put("method", "test");


            String httpConfigPath = "/sdk/api";
            String fullPath = "/test/test1/test11";


            map.put("path", fullPath);
            map.put("httpConfigPath", httpConfigPath);
            map.put("columsInfoList", columsInfoList);

            List generatorType = Arrays.asList("ui", "api");

            List uiType = Arrays.asList("index", "add", "update");

            List apiType = Arrays.asList("page", "list", "one", "add", "update");

            for (Object type : apiType) {
                map.put("apiType", type);
                StringWriter writer = FreemarkerUtil.process("api/js/api.ftl", map);
                StringBuffer buffer = writer.getBuffer();
                System.out.println("type" + type);
                System.out.println("aaaa:\n" + writer);

                File packageDir = new File(templatePath, (httpConfigPath + fullPath + "/" + type.toString().replaceAll("\\.", "\\" + File.separator)));
                if (!packageDir.exists()) {
                    packageDir.mkdirs();
                }
                FileUtils.write(new File(packageDir, type + ".js"), writer.getBuffer());
            }

        } catch (Exception e) {
            log.error(e.getMessage());
        }

        return generatorVO;
    }
}
