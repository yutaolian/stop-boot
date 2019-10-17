package com.stopboot.admin.utils;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Locale;
import java.util.Map;

/**
 * @description:
 * @author: Lianyutao
 * @create: 2019-10-16 17:57
 * @version:
 **/
@Slf4j
public class FreemarkerUtil {

    /**
     * freemarker config
     */
    private static Configuration configuration = new Configuration(Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS);

    static {
        String templatePath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        int pathFlag = templatePath.lastIndexOf("WEB-INF/classes/");
        if (pathFlag > -1) {
            templatePath = templatePath.substring(0, pathFlag);
        }
        try {
            configuration.setDirectoryForTemplateLoading(new File(templatePath, "templates"));
            configuration.setNumberFormat("#");
            configuration.setClassicCompatible(true);
            configuration.setDefaultEncoding("UTF-8");
            configuration.setLocale(Locale.CHINA);
            configuration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
    }

    public static StringWriter process(String templateName, Map<String, Object> params)
            throws IOException, TemplateException {
        Template template = configuration.getTemplate(templateName);
        StringWriter result = new StringWriter();
        template.process(params, result);
        return result;
    }

}
