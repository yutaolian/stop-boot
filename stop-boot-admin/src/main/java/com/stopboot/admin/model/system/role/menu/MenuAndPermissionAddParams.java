package com.stopboot.admin.model.system.role.menu;/**
 * @version:0.0.1
 * @author: Lianyutao
 * @create: 2019-10-30 20:51
 * @description:
 **/

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @version:0.0.1
 * @author: Lianyutao
 * @create: 2019-10-30 20:51
 * @description:
 **/

@Data
public class MenuAndPermissionAddParams implements Serializable {

    /**
     * 角色ID
     */
    private Integer roleId;

    /**
     * 菜单IDs
     */
    private List<Integer> menuIds;

    /**
     * 权限ids
     */
    private List<Integer> permissionIds;
}
