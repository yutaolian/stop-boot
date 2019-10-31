package com.stopboot.admin.service.system.role;

import com.stopboot.admin.base.service.DefaultServiceI;
import com.stopboot.admin.model.system.permission.list.PermissionInfoVO;
import com.stopboot.admin.model.system.role.add.RoleAddParams;
import com.stopboot.admin.model.system.role.list.RoleListVO;
import com.stopboot.admin.model.system.role.list.RoleListParams;
import com.stopboot.admin.model.system.role.menu.MenuAndPermissionAddParams;
import com.stopboot.admin.model.system.role.menu.RoleMenuParams;
import com.stopboot.admin.model.system.role.one.RoleOneParams;
import com.stopboot.admin.model.system.role.one.RoleOneVO;
import com.stopboot.admin.model.system.role.page.RolePageParams;
import com.stopboot.admin.model.system.role.page.RolePageVO;
import com.stopboot.admin.model.system.role.permission.RolePermissionParams;
import com.stopboot.admin.model.system.role.update.RoleUpdateParams;
import com.stopboot.admin.model.system.role.delete.RoleDeleteParams;

import java.util.List;


public interface RoleServiceI extends DefaultServiceI<RolePageVO, RoleListVO, RoleOneVO,
        RolePageParams, RoleListParams, RoleOneParams,
        RoleAddParams, RoleUpdateParams, RoleDeleteParams> {

    boolean roleMenuAndPermissionAdd(MenuAndPermissionAddParams params);

    /**
     * 当前角色的全部权限
     * @param params
     * @return
     */
    List<Integer> rolePermissions(RolePermissionParams params);

    /**
     * 获得当前角色已选的全部菜单
     * @param params
     * @return
     */
    List<Integer> roleMenus(RoleMenuParams params);
}
