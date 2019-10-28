package com.stopboot.admin.service.system.permission;

import com.stopboot.admin.model.system.permission.add.PermissionAddParams;
import com.stopboot.admin.model.system.permission.list.PermissionMenuListParams;
import com.stopboot.admin.model.system.permission.list.PermissionMenuListVO;

import java.util.List;

public interface PermissionServiceI {


    /**
     * 权限管理-菜单权限列表
     * @param params
     * @return
     */
    List<PermissionMenuListVO> permissionMenuList(PermissionMenuListParams params);

    /**
     *  添加权限
     * @param params
     * @return
     */
    boolean add(PermissionAddParams params);
}
