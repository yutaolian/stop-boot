package com.stopboot.admin.controller.system.role;

import com.stopboot.admin.base.controller.DefaultController;
import com.stopboot.admin.common.ResultData;
import com.stopboot.admin.model.system.permission.list.PermissionInfoVO;
import com.stopboot.admin.model.system.permission.list.PermissionListParams;
import com.stopboot.admin.model.system.permission.list.PermissionListVO;
import com.stopboot.admin.model.system.role.add.RoleAddParams;
import com.stopboot.admin.model.system.role.list.RoleListParams;
import com.stopboot.admin.model.system.role.list.RoleListVO;
import com.stopboot.admin.model.system.role.menu.MenuAndPermissionAddParams;
import com.stopboot.admin.model.system.role.menu.RoleMenuParams;
import com.stopboot.admin.model.system.role.one.RoleOneParams;
import com.stopboot.admin.model.system.role.one.RoleOneVO;
import com.stopboot.admin.model.system.role.page.RolePageParams;
import com.stopboot.admin.model.system.role.page.RolePageVO;
import com.stopboot.admin.model.system.role.permission.RolePermissionParams;
import com.stopboot.admin.model.system.role.update.RoleUpdateParams;
import com.stopboot.admin.model.system.role.delete.RoleDeleteParams;
import com.stopboot.admin.service.system.role.RoleServiceI;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description:
 * @author: Lianyutao
 * @create: 2019/10/30 14:06
 * @version: 1.0.1
 **/

@Slf4j
@RestController
@RequestMapping("/system/role")
public class RoleController extends DefaultController<RoleServiceI,
        RolePageVO, RoleListVO, RoleOneVO,
        RolePageParams, RoleListParams, RoleOneParams,
        RoleAddParams, RoleUpdateParams, RoleDeleteParams> {

    @Resource
    private RoleServiceI roleService;

    /**
     * 保存角色的菜单和权限
     * @param params
     * @return
     */
    @PostMapping("save")
    public ResultData save(@Validated @RequestBody MenuAndPermissionAddParams params) {
        ResultData resultData = ResultData.build();
        boolean flag = roleService.roleMenuAndPermissionAdd(params);
        if (flag) {
            resultData.success();
        }
        return resultData;
    }

    /**
     * 获得指定角色的全部权限
     *
     * @param params
     * @return
     */
    @PostMapping("permission")
    public ResultData<List<Integer>> rolePermissions(@Validated @RequestBody RolePermissionParams params) {
        ResultData resultData = ResultData.build();
        List<Integer> rolePermissions = roleService.rolePermissions(params);
        resultData.success(rolePermissions);
        return resultData;
    }


    /**
     * 获得指定角色的全部权限
     *
     * @param params
     * @return
     */
    @PostMapping("menu")
    public ResultData<List<Integer>> roleMenus(@Validated @RequestBody RoleMenuParams params) {
        ResultData resultData = ResultData.build();
        List<Integer> rolePermissions = roleService.roleMenus(params);
        resultData.success(rolePermissions);
        return resultData;
    }
}
