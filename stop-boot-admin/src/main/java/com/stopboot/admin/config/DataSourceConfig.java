package com.stopboot.admin.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.stopboot.admin.db.DataSourceEnum;
import com.stopboot.admin.db.DynamicRoutingDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import tk.mybatis.spring.annotation.MapperScan;

import javax.sql.DataSource;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @description:
 * @author: Lianyutao
 * @create: 2019-09-19 16:49
 * @version:
 **/
@MapperScan({"com.stopboot.admin.dao.*.mapper"})
@Configuration
public class DataSourceConfig {

    @Primary
    @Bean
    @ConfigurationProperties("spring.datasource.druid")
    public DataSource dataSourceMaster() {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean
    @ConfigurationProperties("spring.datasource.slave")
    public DataSource dataSourceSlave() {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean
    @ConfigurationProperties("spring.datasource.log")
    public DataSource dataSourceLog() {
        return DruidDataSourceBuilder.create().build();
    }

    /**
     * 核心动态数据源
     *
     * @return 数据源实例
     */
    @Bean
    public DataSource dynamicDataSource() {
        DynamicRoutingDataSource dataSource = new DynamicRoutingDataSource();
        dataSource.setDefaultTargetDataSource(dataSourceMaster());
        Map<Object, Object> dataSourceMap = new ConcurrentHashMap<>(3);
        dataSourceMap.put(DataSourceEnum.DB_MASTER, dataSourceMaster());
        dataSourceMap.put(DataSourceEnum.DB_SLAVE, dataSourceSlave());
        dataSourceMap.put(DataSourceEnum.DB_LOG, dataSourceLog());
        dataSource.setTargetDataSources(dataSourceMap);
        return dataSource;
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dynamicDataSource());
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:dao/*/mapper/**/*.xml"));
        return sqlSessionFactoryBean.getObject();
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate() throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory());
    }

    /**
     * 事务管理
     * @return 事务管理实例
     */
    @Bean
    public PlatformTransactionManager platformTransactionManager() {
        return new DataSourceTransactionManager(dynamicDataSource());
    }
}
