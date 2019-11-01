package com.stopboot.admin.service.system.menu;

import com.stopboot.admin.common.PageResult;
import com.stopboot.admin.dto.MenuInfo;
import com.stopboot.admin.entity.*;
import com.stopboot.admin.mapper.mybatis.*;
import com.stopboot.admin.base.service.DefaultServiceImpl;
import com.stopboot.admin.model.system.menu.add.MenuAddParams;
import com.stopboot.admin.model.system.menu.list.MenuListVO;
import com.stopboot.admin.model.system.menu.list.MenuListParams;
import com.stopboot.admin.model.system.menu.one.MenuOneParams;
import com.stopboot.admin.model.system.menu.one.MenuOneVO;
import com.stopboot.admin.model.system.menu.page.MenuPageParams;
import com.stopboot.admin.model.system.menu.page.MenuPageVO;
import com.stopboot.admin.model.system.menu.update.MenuUpdateParams;
import com.stopboot.admin.model.system.menu.delete.MenuDeleteParams;
import com.stopboot.admin.utils.BeansHelper;
import com.stopboot.admin.utils.MenuListToTreeUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @description:  Menu service
 * @author: Lianyutao
 * @create: 2019/11/01 16:50
 * @version: 1.0.1
**/

@Slf4j
@Service
public class MenuServiceImpl extends DefaultServiceImpl<SbMenuMapper, SbMenu, SbMenuExample,
        MenuPageVO, MenuListVO, MenuOneVO,
        MenuPageParams, MenuListParams, MenuOneParams,
        MenuAddParams, MenuUpdateParams, MenuDeleteParams>
        implements MenuServiceI {

    @Resource
    private SbMenuMapper sbMenuMapper;

    @Resource
    private SbAdminRolesMapper sbAdminRolesMapper;

    @Resource
    private SbRoleMenusMapper sbRoleMenusMapper;

    @Resource
    private SbRoleMenuPermissionsMapper sbRoleMenuPermissionsMapper;

    @Resource
    private SbMenuPermissionsMapper sbMenuPermissionsMapper;


    @Override
    public PageResult<MenuPageVO> page(MenuPageParams pageParams) {
        SbMenuExample example = new SbMenuExample();
        SbMenuExample.Criteria criteria = example.createCriteria();
        if (!ObjectUtils.isEmpty(pageParams.getId())) {
            criteria.andIdEqualTo(pageParams.getId());
        }
        if (!ObjectUtils.isEmpty(pageParams.getPid())) {
            criteria.andPidEqualTo(pageParams.getPid());
        }
        if (!ObjectUtils.isEmpty(pageParams.getTitle())) {
            criteria.andTitleEqualTo(pageParams.getTitle());
        }
        if (!ObjectUtils.isEmpty(pageParams.getName())) {
            criteria.andNameEqualTo(pageParams.getName());
        }
        if (!ObjectUtils.isEmpty(pageParams.getComponent())) {
            criteria.andComponentEqualTo(pageParams.getComponent());
        }
        if (!ObjectUtils.isEmpty(pageParams.getPath())) {
            criteria.andPathEqualTo(pageParams.getPath());
        }
        if (!ObjectUtils.isEmpty(pageParams.getIcon())) {
            criteria.andIconEqualTo(pageParams.getIcon());
        }
        if (!ObjectUtils.isEmpty(pageParams.getType())) {
            criteria.andTypeEqualTo(pageParams.getType());
        }
        if (!ObjectUtils.isEmpty(pageParams.getLink())) {
            criteria.andLinkEqualTo(pageParams.getLink());
        }
        if (!ObjectUtils.isEmpty(pageParams.getCode())) {
            criteria.andCodeEqualTo(pageParams.getCode());
        }
        if (!ObjectUtils.isEmpty(pageParams.getHidden())) {
            criteria.andHiddenEqualTo(pageParams.getHidden());
        }
        if (!ObjectUtils.isEmpty(pageParams.getStatus())) {
            criteria.andStatusEqualTo(pageParams.getStatus());
        }
        if (!ObjectUtils.isEmpty(pageParams.getSort())) {
            criteria.andSortEqualTo(pageParams.getSort());
        }
        if (!ObjectUtils.isEmpty(pageParams.getDeleteFlag())) {
            criteria.andDeleteFlagEqualTo(pageParams.getDeleteFlag());
        }
        if (!ObjectUtils.isEmpty(pageParams.getOpUserId())) {
            criteria.andOpUserIdEqualTo(pageParams.getOpUserId());
        }
        if (!ObjectUtils.isEmpty(pageParams.getCreateTime())) {
            criteria.andCreateTimeEqualTo(pageParams.getCreateTime());
        }
        if (!ObjectUtils.isEmpty(pageParams.getUpdateTime())) {
            criteria.andUpdateTimeEqualTo(pageParams.getUpdateTime());
        }
        return this.pageByExample(pageParams, example);
    }


    /**
     * 1.根据用户id 获得用户全部角色
     * 2.根据角色获得用户的菜单
     * 3.根据角色获得用户菜单的权限
     *
     * @param params
     * @return
     */
    @Override
    public List<MenuListVO> list(MenuListParams params) {
        params.setUserId(1);
        //根据用户获得角色列表
        SbAdminRolesExample sbAdminRolesExample = new SbAdminRolesExample();
        SbAdminRolesExample.Criteria criteria = sbAdminRolesExample.createCriteria();
        criteria.andAdminIdEqualTo(params.getUserId());
        List<SbAdminRoles> sbAdminRoles = sbAdminRolesMapper.selectByExample(sbAdminRolesExample);

        List<Integer> roleIds = sbAdminRoles.stream().map(SbAdminRoles::getRoleId).collect(Collectors.toList());
        //根据角色获得全的菜单且去重

        SbRoleMenusExample sbRoleMenusExample = new SbRoleMenusExample();
        SbRoleMenusExample.Criteria criteria1 = sbRoleMenusExample.createCriteria();
        criteria1.andRoldIdIn(roleIds);
        List<SbRoleMenus> sbRoleMenus = sbRoleMenusMapper.selectByExample(sbRoleMenusExample);
        //菜单去重
        Set<Integer> menuIds = sbRoleMenus.stream().map(SbRoleMenus::getMenuId).collect(Collectors.toSet());

        List<MenuListVO> menuLists = BeansHelper.getInstance().convert(getAllMenus(new ArrayList<>(menuIds)), MenuListVO.class);

        //数据库中仅保存叶子节点。这里需补全整颗树 没有选中根节点时需补全树

//        Iterator<MenuListVO> iterator = menuLists.iterator();
//        while (iterator.hasNext()) {
//            MenuListVO menuListVO = iterator.next();
//            Integer pid = menuListVO.getPid();
//            if (pid != 0 && pid != 1 && !menuIds.contains(pid)) {
//                MenuListVO parentMenu = (MenuListVO) BeansHelper.getInstance().convert(getOne(pid), MenuListVO.class);
//                menuLists.add(parentMenu);
//            }
//        }

        Set<MenuListVO> tempMenu = new HashSet<>();
        if (!menuIds.contains(1)) {
            for (MenuListVO menuListVO : menuLists) {
                Integer pid = menuListVO.getPid();
                if (pid != 0 && pid != 1 && !menuIds.contains(pid)) {
                    MenuListVO parentMenu = (MenuListVO) BeansHelper.getInstance().convert(getOne(pid), MenuListVO.class);
                    tempMenu.add(parentMenu);
                }
            }
        }

        menuLists.addAll(tempMenu);

        //设置menu对应的权限列表
        SbRoleMenuPermissionsExample sbRoleMenuPermissionsExample = new SbRoleMenuPermissionsExample();
        SbRoleMenuPermissionsExample.Criteria criteria2 = sbRoleMenuPermissionsExample.createCriteria();
        criteria2.andRoleIdIn(roleIds);
        List<SbRoleMenuPermissions> sbRoleMenuPermissions = sbRoleMenuPermissionsMapper.selectByExample(sbRoleMenuPermissionsExample);
        //权限id去重
        Set<Integer> permissions = sbRoleMenuPermissions.stream().map(SbRoleMenuPermissions::getMenuPermissionId).collect(Collectors.toSet());


        for (MenuListVO menuListVO : menuLists) {
            SbMenuPermissionsExample sbMenuPermissionsExample = new SbMenuPermissionsExample();
            SbMenuPermissionsExample.Criteria criteria3 = sbMenuPermissionsExample.createCriteria();
            criteria3.andIdIn(new ArrayList<>(permissions));
            criteria3.andMenuIdEqualTo(menuListVO.getId());
            List<SbMenuPermissions> sbMenuPermissions = sbMenuPermissionsMapper.selectByExample(sbMenuPermissionsExample);
            List<String> permissionTags = sbMenuPermissions.stream().map(SbMenuPermissions::getTag).collect(Collectors.toList());
            menuListVO.setPermissions(permissionTags);
        }

        List<MenuListVO> menuListVOList = MenuListToTreeUtil.getInstance().listToTree(menuLists);
        if (menuListVOList != null && menuListVOList.size() > 0) {
            return menuListVOList;
        } else {
            return null;
        }
    }


    @Override
    public MenuInfo getAllMenuInfoById(Integer menuId) {
        List<String> fullPathArray = new ArrayList<>();
        MenuInfo allParentNode = getAllParentNode(fullPathArray, menuId);
        String fullPath = "";
        for (String str : fullPathArray) {
            fullPath += str.startsWith("/") ? str : "/" + str;
        }
        allParentNode.setFullPath(fullPath);
        return allParentNode;
    }


    private MenuInfo getAllParentNode(List<String> fullPathArray, Integer menuId) {
        SbMenu menu = getOne(menuId);
        MenuInfo menuInfo = (MenuInfo) BeansHelper.getInstance().convert(menu, MenuInfo.class);
        if (1 != menu.getPid()) {
            menuInfo.setParent(getAllParentNode(fullPathArray, menuInfo.getPid()));
        }
        fullPathArray.add(menuInfo.getPath());
        return menuInfo;
    }

    /**
     * 可加缓存
     *
     * @param menuId
     * @return
     */
    private SbMenu getOne(Integer menuId) {
        return sbMenuMapper.selectByPrimaryKey(menuId);
    }

    @Override
    public List<SbMenu> getAllMenus(List<Integer> ids) {
        SbMenuExample sbMenuExample = new SbMenuExample();
        sbMenuExample.setOrderByClause(" pid , sort  ");
        SbMenuExample.Criteria criteria = sbMenuExample.createCriteria();
        criteria.andDeleteFlagEqualTo(1);
        if (ids != null && ids.size() > 0) {
            ids.add(1);
            criteria.andIdIn(ids);
        }
        List<SbMenu> sbMenuList = sbMenuMapper.selectByExample(sbMenuExample);
        return sbMenuList;
    }


    /**
     * 获得全部显示的菜单
     *
     * @return
     */
    @Override
    public List<SbMenu> getAllShowMenus() {
        SbMenuExample sbMenuExample = new SbMenuExample();
        sbMenuExample.setOrderByClause(" pid , sort ,id ");
        SbMenuExample.Criteria criteria = sbMenuExample.createCriteria();
        criteria.andDeleteFlagEqualTo(1);
        criteria.andStatusEqualTo(1);
        List<SbMenu> sbMenuList = sbMenuMapper.selectByExample(sbMenuExample);
        return sbMenuList;
    }

}
