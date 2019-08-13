package com.stopboot.admin.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * @description: 从库数据源
 * @author: Lianyutao
 * @create: 2019-08-13 16:43
 * @version:
 **/

@Configuration
public class DataSourceSlaveConfig {

    //绑定配置
//    @Primary
//    @Bean(name = "slave")
//    @ConfigurationProperties(prefix = "spring.datasource.slave")
//    public DataSource slave() {
//        return DataSourceBuilder.create().build();
//    }

}
