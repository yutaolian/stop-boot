package com.stopboot.admin.model.help.generator.dowm;/**
 * @version:0.0.1
 * @author: Lianyutao
 * @create: 2019-10-17 13:58
 * @description:
 **/

import com.stopboot.admin.base.params.BaseParams;
import com.stopboot.admin.model.help.datasource.table.list.TableListVO;
import com.stopboot.admin.model.help.generator.pre.MenuInfoVO;
import lombok.Data;

import java.util.List;

/**
 * @version:0.0.1
 *
 * @author: Lianyutao
 *
 * @create: 2019-10-17 13:58

 * @description:
 **/

@Data
public class GeneratorParams extends BaseParams {

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


}
