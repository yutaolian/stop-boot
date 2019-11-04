package com.stopboot.admin.model.help.generator.pre;

import com.stopboot.admin.model.help.datasource.table.list.TableListVO;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @description:
 * @author: Lianyutao
 * @create: 2019-10-16 16:40
 * @version:
 **/

@Data
public class GeneratorPreVO implements Serializable {

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
     * 菜单信息
     */
    private MenuInfoVO menuInfo;

    /**
     * 表信息
     */
    private List<TableListVO> tableList;


    /**
     * 默认代码输出路径
     */
    private String defaultGeneratorPath;

    private String adminPath;

    private String sdkPath;

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
