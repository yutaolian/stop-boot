package com.stopboot.admin.model.help.generator;

import lombok.Data;

import java.io.Serializable;

/**
 * @description: 基本信息
 * @author: Lianyutao
 * @create: 2019-10-16 21:20
 * @version:
 **/

@Data
public class BaseInfo implements Serializable {

    /**
     * 作者
     */
    private String author;

    /**
     * 模板路径
     */
    private String templatePath;

    private String viewPath;

    private String fullPath;

}
