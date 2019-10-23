package com.stopboot.admin.generator.impl.ui;/**
 * @version:0.0.1
 * @author: Lianyutao
 * @create: 2019-10-22 21:25
 * @description: ui生成实现
 **/

import com.stopboot.admin.generator.SbGeneratorStrategy;
import com.stopboot.admin.generator.SbGeneratorStrategyParams;
import com.stopboot.admin.model.help.generator.BaseInfo;
import com.stopboot.admin.utils.FreemarkerUtil;
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
 * @description:
 **/

@Service
public class SbUiGeneratorStrategyImpl implements SbGeneratorStrategy {

    @Override
    public boolean judge(SbGeneratorStrategyParams marketStrategyParam) {
        return marketStrategyParam.getName().equals("ui") ? true : false;
    }

    @Override
    public void execute(SbGeneratorStrategyParams marketStrategyParam) {

        BaseInfo baseInfo = marketStrategyParam.getBaseInfo();
        String templatePath = baseInfo.getTemplatePath();
        String viewPath = baseInfo.getTemplatePath();
        String fullPath = baseInfo.getTemplatePath();

        Map<String, Object> data = marketStrategyParam.getData();
        List uiType = Arrays.asList("index", "create", "edit");
        //生成admin逻辑
        for (Object type : uiType) {
            data.put("uiType", type);
            StringWriter writer = null;
            try {
                writer = FreemarkerUtil.process("ui/vue/" + type + ".ftl", data);

                System.out.println("writer:\n" + writer);
                File packageDir = new File(templatePath, (viewPath + fullPath));
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
