package com.stopboot.admin.model.system.permission.add;/**
 * @version:0.0.1
 * @author: Lianyutao
 * @create: 2019-10-28 19:33
 * @description:
 **/

import lombok.Data;

import java.io.Serializable;

/**
 * @version:0.0.1
 * @author: Lianyutao
 * @create: 2019-10-28 19:33
 * @description:
 **/

@Data
public class PermissionAddParams implements Serializable {

    private Integer menuId;

    /**
     * 权限tag
     */
    private String tag;


}
