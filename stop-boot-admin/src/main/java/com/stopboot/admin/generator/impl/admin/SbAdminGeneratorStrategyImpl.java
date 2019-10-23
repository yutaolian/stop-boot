package com.stopboot.admin.generator.impl.admin;/**
 * @version:0.0.1
 * @author: Lianyutao
 * @create: 2019-10-23 10:01
 * @description:
 **/

import com.stopboot.admin.generator.SbGeneratorStrategy;
import com.stopboot.admin.generator.SbGeneratorStrategyParams;
import com.stopboot.admin.model.help.generator.BaseInfo;
import com.stopboot.admin.utils.FreemarkerUtil;
import com.stopboot.admin.utils.StringUtil;
import freemarker.template.TemplateException;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @version:0.0.1
 * @author: Lianyutao
 * @create: 2019-10-23 10:01
 * @description: 生成后台逻辑代码
 **/
@Service
public class SbAdminGeneratorStrategyImpl implements SbGeneratorStrategy {

    @Override
    public boolean judge(SbGeneratorStrategyParams marketStrategyParam) {
        return marketStrategyParam.getName().equals("admin") ? true : false;
    }

    @Override
    public void execute(SbGeneratorStrategyParams marketStrategyParam) {
        BaseInfo baseInfo = marketStrategyParam.getBaseInfo();
        String templatePath = baseInfo.getTemplatePath();
        String viewPath = baseInfo.getTemplatePath();
        String fullPath = baseInfo.getTemplatePath();
        String model = baseInfo.getModel();
        String basePackageToPath = baseInfo.getBasePackageToPath();

        Map<String, Object> data = marketStrategyParam.getData();

        List bizType = Arrays.asList("controller", "service", "serviceImpl", "params");

        List apiType = Arrays.asList("page", "one", "add", "update", "delete");
//生成admin逻辑
        for (Object type : bizType) {
            data.put("bizType", type);

            try {
                if (type.toString().equals("serviceImpl")) {
                    StringWriter writer = FreemarkerUtil.process("admin/" + type + ".ftl", data);
                    System.out.println("writer:\n" + writer);

                    File packageDir = new File(templatePath, (basePackageToPath + "/" + type.toString().substring(0, type.toString().length() - 4).replaceAll("\\.", "\\" + File.separator)) + fullPath);
                    if (!packageDir.exists()) {
                        packageDir.mkdirs();
                    }
                    FileUtils.write(new File(packageDir, StringUtil.captureName(model) + StringUtil.captureName(type.toString()) + ".java"), writer.getBuffer());
                } else if (type.toString().equals("params")) {
                    for (Object t : apiType) {
                        data.put("bizParamsType", t);
                        {
                            StringWriter writer = FreemarkerUtil.process("admin/" + type + ".ftl", data);
                            StringBuffer buffer = writer.getBuffer();

                            File packageDir = new File(templatePath, (basePackageToPath + "/" + type.toString().replaceAll("\\.", "\\" + File.separator)) + fullPath + "/" + t.toString());
                            if (!packageDir.exists()) {
                                packageDir.mkdirs();
                            }
                            FileUtils.write(new File(packageDir, StringUtil.captureName(model) + StringUtil.captureName(t.toString()) + "Params.java"), writer.getBuffer());
                        }
                        if (t.toString().equals("page") || t.toString().equals("one")) {
                            {
                                StringWriter writer = FreemarkerUtil.process("admin/vo.ftl", data);
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
                    StringWriter writer = FreemarkerUtil.process("admin/" + type + ".ftl", data);
                    System.out.println("writer:\n" + writer);

                    File packageDir = new File(templatePath, (basePackageToPath + "/" + type.toString().replaceAll("\\.", "\\" + File.separator)) + fullPath + "/");
                    if (!packageDir.exists()) {
                        packageDir.mkdirs();
                    }
                    FileUtils.write(new File(packageDir, StringUtil.captureName(model) + StringUtil.captureName(type.toString()) + ".java"), writer.getBuffer());
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (TemplateException e) {
                e.printStackTrace();
            }

        }
    }
}
