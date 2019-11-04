package com.stopboot.admin.config;/**
 * @version:0.0.1
 * @author: Lianyutao
 * @create: 2019-10-23 14:25
 * @description:
 **/

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * @version:0.0.1
 * @author: Lianyutao
 * @create: 2019-10-23 14:25
 * @description:
 **/

@Data
@Configuration
@ConfigurationProperties(prefix = "generator.default")
public class GeneratorConfig {

    /**
     * 项目名称
     */
    private String author;

    /**
     * 项目名称
     */
    private String projectName;

    /**
     * 项目描述
     */
    private String projectDesc;

    /**
     * 项目版本
     */
    private String version;

    /**
     * 后台基础包名
     * 默认后台java代码生成的包名为
     * basePackage.controller.具体业务模块 控制器
     * basePackage.service.具体业务模块 服务接口及实现类
     * basePackage.model.具体业务模块 请求参数及返回参数
     */
    private String basePackage;

    /**
     * 后端项目jssdk 网络请求的位置 默认在 项目名/src/sdk/api/
     */
    private String jsSdkConfigPath;

//    /**
//     * 管理平台vue代码默认的保存位置 项目名/src/views
//     */
//    private String viewPath;

    /**
     * 使用mybatis-generator 生成代码后实体类的默认保存位置
     * com.stopboot.admin.entity.实体类
     */
    private String entityPackage;

    /**
     * 使用mybatis-generator 生成代码后实体类Example的默认保存位置
     * com.stopboot.admin.entity.实体类Example
     */
    private String entityExamplePackage;

    /**
     * 使用mybatis-generator 生成代码后实体类 mapper的默认保存位置
     * com.stopboot.admin.mapper.mybatis.实体类mapper
     */
    private String entityMapperPackage;

    /**
     * 后台代码的路径
     */
    private String adminPath;

    /**
     * sdk路径
     */
    private String sdkPath;

    /**
     * vue 代码路径
     */
    private String viewPath;


    /**
     * 功能类型
     */
    private List<String> functionTypes;

    /**
     * 业务类型
     */
    private List<String> bizTypes;


}
