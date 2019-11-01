package com.stopboot.admin.model.system.permission.list;/**
 * @version:0.0.1
 * @author: Lianyutao
 * @create: 2019-10-29 15:25
 * @description:
 **/

import lombok.Data;

import java.io.Serializable;

/**
 * @version:0.0.1
 * @author: Lianyutao
 * @create: 2019-10-29 15:25
 * @description:
 **/

@Data
public class PermissionInfoVO implements Serializable {

    private Integer id;

    private String tag;

    /**
     *权限tag名称
     *
     */
    private String tagName;

    private String tagDesc;

    /**
     * 当前权限的接口地址
     */
    private String url;


}
