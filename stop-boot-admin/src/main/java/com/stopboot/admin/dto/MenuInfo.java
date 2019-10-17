package com.stopboot.admin.dto;/**
 * @version:0.0.1
 * @author: Lianyutao
 * @create: 2019-10-17 14:16
 * @description:
 **/

import lombok.Data;

import java.io.Serializable;

/**
 * @version:0.0.1
 * @author: Lianyutao
 * @create: 2019-10-17 14:16
 * @description:
 **/

@Data
public class MenuInfo implements Serializable {

    private Integer id;
    private Integer pid;
    private String path;
    private String component;
    private String name;
    private String icon;
    private String title;
    private MenuInfo parent;

    private String fullPath;

}
