package com.stopboot.admin.model.help.generator;

import com.stopboot.admin.model.help.datasource.table.columns.TableColumnsVO;
import com.stopboot.admin.model.help.generator.pre.MenuInfoVO;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @description: 基本信息
 * @author: Lianyutao
 * @create: 2019-10-16 21:20
 * @version:
 **/

@Data
public class GeneratorInfo implements Serializable {

    /**
     * 默认代码输出路径
     */
    private String defaultGeneratorPath;

    private String currentType;

    private String menuComponent;


    /**
     * 菜单ID
     */
    private Integer menuId;
    /**
     * 菜单标题
     */
    private String title;

    private String fullPath;

    private String fullPathToPackage;

    private String path;

    /**
     * 基础包名转为带斜线的路径
     */
    private String basePackageToPath;

    /**
     * 模块名
     */
    private String model;

    private Date date;

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
     * 选中的表名
     */
    private String tableName;

    /**
     * 其他值
     */
    private Map<String, Object> data;

    /**
     * 表信息
     */
    private List<TableColumnsVO> tableColumnsData;

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

}
