package com.stopboot.admin.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * @description: 主库数据源配置
 * @author: Lianyutao
 * @create: 2019-08-13 16:41
 * @version:
 **/

@Configuration
public class DataSourceMasterConfig {
    /**
     * 主库数据源
     *
     * @return
     */
    @Primary
    @Bean
    @ConfigurationProperties("spring.datasource.druid")
    public DataSource dataSourceMain() {
        return DruidDataSourceBuilder.create().build();
    }
}
