package com.stopboot.admin.config;

/**
 * @description: 代码生成工具类
 * @author: Lianyutao
 * @create: 2019-09-24 10:49
 * @version:
 **/

public interface CodeGeneratorConfig {

    /**
     * 生成的模板语言
     */
    String TEMPLATE_LANG_JAVA = "java";


    /**
     * 模板路径-后台代码 Controller
     */
    String TEMPLATE_ADMIN_CONTROLLER = "admin/Controller.ftl";

    /**
     * 模板路径-后台代码 Controller
     */
    String TEMPLATE_ADMIN_SERVICE = "admin/Service.ftl";

    /**
     * 模板路径-后台代码 Controller
     */
    String TEMPLATE_ADMIN_SERVICEIMPL = "admin/ServiceImpl.ftl";

    /**
     * 模板路径-vue代码 列表
     */
    String TEMPLATE_VUE_INDEX = "vue/index.ftl";

    /**
     * 模板路径-vue代码 添加
     */
    String TEMPLATE_VUE_ADD = "vue/add.ftl";

    /**
     * 模板路径-vue代码 更新
     */
    String TEMPLATE_VUE_UPDATE= "vue/update.ftl";

    /**
     * 模板路径-vue代码 api
     */
    String TEMPLATE_VUE_API = "vue/api.ftl";



}
