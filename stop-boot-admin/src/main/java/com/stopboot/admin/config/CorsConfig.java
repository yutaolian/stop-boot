package com.stopboot.admin.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @description:
 * @author: Lianyutao
 * @create: 2019-09-12 18:30
 * @version:
 **/

@Configuration
public class CorsConfig extends WebMvcConfigurerAdapter {
        @Override
        public void addCorsMappings (CorsRegistry registry){
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE")
                .maxAge(3600)
                .allowCredentials(true);
    }
}
