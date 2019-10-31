package com.stopboot.admin.strategy.generator.impl.admin;/**
 * @version:0.0.1
 * @author: Lianyutao
 * @create: 2019-10-23 10:01
 * @description:
 **/

import com.stopboot.admin.model.help.generator.GeneratorInfo;
import com.stopboot.admin.strategy.generator.SbGeneratorStrategy;
import com.stopboot.admin.strategy.generator.SbGeneratorStrategyParams;
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
        return true;
    }

    @Override
    public void execute(SbGeneratorStrategyParams marketStrategyParam) {
        GeneratorInfo generatorInfo = marketStrategyParam.getGeneratorInfo();
        List<String> bizType = Arrays.asList("controller", "serviceI", "serviceImpl", "model");
        List<String> apiType = Arrays.asList("page", "list", "one", "add", "update", "delete");

        String basePath = generatorInfo.getAdminPath();
//        String basePath = generatorInfo.getDefaultGeneratorPath();

        //生成admin逻辑
        for (String type : bizType) {
            try {
                if (type.equals("serviceImpl") || type.equals("serviceI")) {
                    StringWriter writer = FreemarkerUtil.process("admin/" + type + ".ftl", generatorInfo);
                    System.out.println("writer:\n" + writer);
                    String filePath = generatorInfo.getBasePackageToPath() + "/service" + generatorInfo.getFullPath();
                    File packageDir = new File(basePath, filePath);
                    if (!packageDir.exists()) {
                        packageDir.mkdirs();
                    }
                    FileUtils.write(new File(packageDir, StringUtil.captureName(generatorInfo.getModel()) + StringUtil.captureName(type) + ".java"), writer.getBuffer());
                } else if (type.equals("model")) {
                    for (String type2 : apiType) {
                        generatorInfo.setCurrentType(type2);
                        {
                            StringWriter writer = FreemarkerUtil.process("admin/params.ftl", generatorInfo);
                            StringBuffer buffer = writer.getBuffer();
                            String filePath = generatorInfo.getBasePackageToPath() + "/" + type + generatorInfo.getFullPath() + "/" + type2;
                            File packageDir = new File(basePath, filePath);
                            if (!packageDir.exists()) {
                                packageDir.mkdirs();
                            }
                            FileUtils.write(new File(packageDir, StringUtil.captureName(generatorInfo.getModel()) + StringUtil.captureName(type2) + "Params.java"), writer.getBuffer());
                        }
                        if (type2.equals("page") || type2.equals("list") || type2.equals("one")) {
                            {
                                StringWriter writer = FreemarkerUtil.process("admin/vo.ftl", generatorInfo);
                                StringBuffer buffer = writer.getBuffer();
                                String filePath = generatorInfo.getBasePackageToPath() + "/" + type + generatorInfo.getFullPath() + "/" + type2;
                                File packageDir = new File(basePath, filePath);
                                if (!packageDir.exists()) {
                                    packageDir.mkdirs();
                                }
                                FileUtils.write(new File(packageDir, StringUtil.captureName(generatorInfo.getModel()) + StringUtil.captureName(type2) + "VO.java"), writer.getBuffer());
                            }
                        }
                    }
                } else {
                    StringWriter writer = FreemarkerUtil.process("admin/" + type + ".ftl", generatorInfo);
                    System.out.println("writer:\n" + writer);
                    String filePath = generatorInfo.getBasePackageToPath() + "/" + type + generatorInfo.getFullPath();
                    File packageDir = new File(basePath, filePath);
                    if (!packageDir.exists()) {
                        packageDir.mkdirs();
                    }
                    FileUtils.write(new File(packageDir, StringUtil.captureName(generatorInfo.getModel()) + StringUtil.captureName(type.toString()) + ".java"), writer.getBuffer());
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (TemplateException e) {
                e.printStackTrace();
            }

        }
    }
}
