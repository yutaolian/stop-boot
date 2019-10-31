package com.stopboot.admin.service.system.role;

import com.stopboot.admin.common.PageResult;
import com.stopboot.admin.entity.*;
import com.stopboot.admin.mapper.mybatis.SbMenuPermissionsMapper;
import com.stopboot.admin.mapper.mybatis.SbRoleMapper;
import com.stopboot.admin.base.service.DefaultServiceImpl;
import com.stopboot.admin.mapper.mybatis.SbRoleMenuPermissionsMapper;
import com.stopboot.admin.mapper.mybatis.SbRoleMenusMapper;
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
import com.stopboot.admin.utils.BeansHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @description: Role service
 * @author: Lianyutao
 * @create: 2019/10/30 14:06
 * @version: 1.0.1
 **/

@Slf4j
@Service
public class RoleServiceImpl extends DefaultServiceImpl<SbRoleMapper, SbRole, SbRoleExample,
        RolePageVO, RoleListVO, RoleOneVO,
        RolePageParams, RoleListParams, RoleOneParams,
        RoleAddParams, RoleUpdateParams, RoleDeleteParams>
        implements RoleServiceI {

    @Resource
    private SbRoleMenusMapper sbRoleMenusMapper;

    @Resource
    private SbRoleMenuPermissionsMapper sbRoleMenuPermissionsMapper;

    @Resource
    private SbMenuPermissionsMapper sbMenuPermissionsMapper;


    @Override
    public PageResult<RolePageVO> page(RolePageParams pageParams) {
        SbRoleExample example = new SbRoleExample();
        SbRoleExample.Criteria criteria = example.createCriteria();
        if (!ObjectUtils.isEmpty(pageParams.getId())) {
            criteria.andIdEqualTo(pageParams.getId());
        }
        if (!ObjectUtils.isEmpty(pageParams.getName())) {
            criteria.andNameEqualTo(pageParams.getName());
        }
        if (!ObjectUtils.isEmpty(pageParams.getDescription())) {
            criteria.andDescriptionEqualTo(pageParams.getDescription());
        }
        if (!ObjectUtils.isEmpty(pageParams.getTag())) {
            criteria.andTagEqualTo(pageParams.getTag());
        }
        if (!ObjectUtils.isEmpty(pageParams.getStatus())) {
            criteria.andStatusEqualTo(pageParams.getStatus());
        }
        if (!ObjectUtils.isEmpty(pageParams.getCreateTime())) {
            criteria.andCreateTimeEqualTo(pageParams.getCreateTime());
        }
        if (!ObjectUtils.isEmpty(pageParams.getUpdateTime())) {
            criteria.andUpdateTimeEqualTo(pageParams.getUpdateTime());
        }
        if (!ObjectUtils.isEmpty(pageParams.getDeleteFlag())) {
            criteria.andDeleteFlagEqualTo(pageParams.getDeleteFlag());
        }

        return this.pageByExample(pageParams, example);
    }

    /**
     * 保存角色的菜单和权限关系
     *
     * @param params
     * @return
     */
    @Override
    @Transactional
    public boolean roleMenuAndPermissionAdd(MenuAndPermissionAddParams params) {
        try {
            Integer roleId = params.getRoleId();
            //清楚当前角色菜单和权限
            SbRoleMenusExample sbRoleMenusExample = new SbRoleMenusExample();
            SbRoleMenusExample.Criteria criteria = sbRoleMenusExample.createCriteria();
            criteria.andRoldIdEqualTo(roleId);
            sbRoleMenusMapper.deleteByExample(sbRoleMenusExample);

            SbRoleMenuPermissionsExample sbRoleMenuPermissionsExample = new SbRoleMenuPermissionsExample();
            SbRoleMenuPermissionsExample.Criteria criteria1 = sbRoleMenuPermissionsExample.createCriteria();
            criteria1.andRoleIdEqualTo(roleId);
            sbRoleMenuPermissionsMapper.deleteByExample(sbRoleMenuPermissionsExample);

            //保存菜单和权限

            List<Integer> menuIds = params.getMenuIds();
            for (Integer menuId : menuIds) {
                SbRoleMenus sbRoleMenus = new SbRoleMenus();
                sbRoleMenus.setMenuId(menuId);
                sbRoleMenus.setRoldId(roleId);
                sbRoleMenusMapper.insertSelective(sbRoleMenus);
            }

            List<Integer> permissionIds = params.getPermissionIds();
            for (Integer permissionId : permissionIds) {
                SbRoleMenuPermissions sbRoleMenuPermissions = new SbRoleMenuPermissions();
                sbRoleMenuPermissions.setMenuPermissionId(permissionId);
                sbRoleMenuPermissions.setRoleId(roleId);
                sbRoleMenuPermissionsMapper.insertSelective(sbRoleMenuPermissions);
            }
            return true;
        } catch (Exception e) {
            log.error("roleMenuAndPermissionAdd exception:", e.getMessage());
            return false;
        }
    }


    @Override
    public List<Integer> rolePermissions(RolePermissionParams params) {
        SbRoleMenuPermissionsExample sbRoleMenuPermissionsExample = new SbRoleMenuPermissionsExample();
        SbRoleMenuPermissionsExample.Criteria criteria1 = sbRoleMenuPermissionsExample.createCriteria();
        criteria1.andRoleIdEqualTo(params.getRoleId());
        List<SbRoleMenuPermissions> sbRoleMenuPermissions = sbRoleMenuPermissionsMapper.selectByExample(sbRoleMenuPermissionsExample);
        return sbRoleMenuPermissions.stream().map(SbRoleMenuPermissions::getMenuPermissionId).collect(Collectors.toList());
    }


    @Override
    public List<Integer> roleMenus(RoleMenuParams params) {
        SbRoleMenusExample sbRoleMenusExample = new SbRoleMenusExample();
        SbRoleMenusExample.Criteria criteria = sbRoleMenusExample.createCriteria();
        criteria.andRoldIdEqualTo(params.getRoleId());
        List<SbRoleMenus> sbRoleMenus = sbRoleMenusMapper.selectByExample(sbRoleMenusExample);
        return sbRoleMenus.stream().map(SbRoleMenus::getMenuId).collect(Collectors.toList());
    }
}
