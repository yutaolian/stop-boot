package com.stopboot.admin.strategy.generator.impl.ui;/**
 * @version:0.0.1
 * @author: Lianyutao
 * @create: 2019-10-22 21:25
 * @description: ui生成实现
 **/

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
 * @version:0.0.1
 * @author: Lianyutao
 * @create: 2019-10-23 10:01
 * @description:
 **/

@Service
public class SbUiGeneratorStrategyImpl implements SbGeneratorStrategy {

    @Override
    public boolean judge(SbGeneratorStrategyParams marketStrategyParam) {
        return true;
    }

    @Override
    public void execute(SbGeneratorStrategyParams marketStrategyParam) {
        GeneratorInfo generatorInfo = marketStrategyParam.getGeneratorInfo();
        List<String> uiType = Arrays.asList("index", "create", "edit");
        String basePath = generatorInfo.getSdkPath();
//        String basePath = generatorInfo.getDefaultGeneratorPath();
        //生成admin逻辑
        for (String type : uiType) {
            generatorInfo.setCurrentType(type);
            StringWriter writer = null;
            try {
                writer = FreemarkerUtil.process("ui/vue/" + type + ".ftl", generatorInfo);
                System.out.println("writer:\n" + writer);
                File packageDir = new File(basePath, generatorInfo.getMenuComponent());
                if (!packageDir.exists()) {
                    packageDir.mkdirs();
                }
                FileUtils.write(new File(packageDir, type + ".vue"), writer.getBuffer());
            } catch (IOException e) {
                e.printStackTrace();
            } catch (TemplateException e) {
                e.printStackTrace();
            }
        }
    }
}
