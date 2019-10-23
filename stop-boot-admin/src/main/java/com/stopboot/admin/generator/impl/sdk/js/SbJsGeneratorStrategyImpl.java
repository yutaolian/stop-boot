package com.stopboot.admin.generator.impl.sdk.js;


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
 * @description:
 * @author: Lianyutao
 * @create: 2019-10-16 21:06
 * @version:
 **/
@Service
public class SbJsGeneratorStrategyImpl implements SbGeneratorStrategy {

    @Override
    public boolean judge(SbGeneratorStrategyParams marketStrategyParam) {
        return marketStrategyParam.getName().equals("js") ? true : false;
    }

    @Override
    public void execute(SbGeneratorStrategyParams marketStrategyParam) {
        BaseInfo baseInfo = marketStrategyParam.getBaseInfo();
        String templatePath = baseInfo.getTemplatePath();
        String viewPath = baseInfo.getTemplatePath();
        String fullPath = baseInfo.getTemplatePath();
        String httpConfigPath = baseInfo.getHttpConfigPath();

        Map<String, Object> data = marketStrategyParam.getData();


        List apiType = Arrays.asList("page", "one", "add", "update", "delete");
        //生成api接口
        for (Object type : apiType) {
            data.put("apiType", type);
            StringWriter writer = null;
            try {
                writer = FreemarkerUtil.process("api/js/api.ftl", data);
                StringBuffer buffer = writer.getBuffer();
//                System.out.println("type" + type);
//                System.out.println("writer:\n" + writer);

                File packageDir = new File(templatePath, (httpConfigPath + fullPath + "/" + type.toString().replaceAll("\\.", "\\" + File.separator)));
                if (!packageDir.exists()) {
                    packageDir.mkdirs();
                }
                FileUtils.write(new File(packageDir, type + ".js"), writer.getBuffer());
            } catch (IOException e) {
                e.printStackTrace();
            } catch (TemplateException e) {
                e.printStackTrace();
            }

        }
    }
}
