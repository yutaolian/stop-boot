package com.stopboot.admin.strategy.generator.impl.sdk.js;


import com.stopboot.admin.model.help.generator.GeneratorInfo;
import com.stopboot.admin.strategy.generator.SbGeneratorStrategy;
import com.stopboot.admin.strategy.generator.SbGeneratorStrategyParams;
import com.stopboot.admin.utils.FreemarkerUtil;
import freemarker.template.TemplateException;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * @author: Lianyutao
 * @create: 2019-10-16 21:06
 * @version:
 **/
@Service
public class SbJsGeneratorStrategyImpl implements SbGeneratorStrategy {

    @Override
    public boolean judge(SbGeneratorStrategyParams marketStrategyParam) {
        return true;
    }

    @Override
    public void execute(SbGeneratorStrategyParams marketStrategyParam) {
        GeneratorInfo generatorInfo = marketStrategyParam.getGeneratorInfo();
        List<String> apiType = Arrays.asList("page", "list", "one", "add", "update", "delete");

        String basePath = generatorInfo.getSdkPath();
//        String basePath = generatorInfo.getDefaultGeneratorPath();
        //生成api接口
        for (String type : apiType) {
            generatorInfo.setCurrentType(type);
            StringWriter writer = null;
            try {
                writer = FreemarkerUtil.process("api/js/api.ftl", generatorInfo);
                StringBuffer buffer = writer.getBuffer();
                System.out.println("js api data:\n" + buffer);
                String filePath = generatorInfo.getJsSdkConfigPath() + generatorInfo.getFullPath() + "/" + type.toString().replaceAll("\\.", "\\" + File.separator);
                File packageDir = new File(basePath, filePath);
                if (!packageDir.exists()) {
                    packageDir.mkdirs();
                }
                FileUtils.write(new File(packageDir,  "index.js"), writer.getBuffer());
            } catch (IOException e) {
                e.printStackTrace();
            } catch (TemplateException e) {
                e.printStackTrace();
            }

        }
    }
}
