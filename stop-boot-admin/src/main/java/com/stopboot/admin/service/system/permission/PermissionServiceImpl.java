package com.stopboot.admin.service.system.permission;

/**
 * @version:0.0.1
 * @author: Lianyutao
 * @create: 2019-10-28 18:51
 * @description:
 **/

import com.stopboot.admin.entity.SbMenu;
import com.stopboot.admin.entity.SbMenuPermissions;
import com.stopboot.admin.entity.SbMenuPermissionsExample;
import com.stopboot.admin.mapper.mybatis.SbMenuPermissionsMapper;
import com.stopboot.admin.model.system.permission.add.PermissionAddParams;
import com.stopboot.admin.model.system.permission.list.PermissionMenuListParams;
import com.stopboot.admin.model.system.permission.list.PermissionMenuListVO;
import com.stopboot.admin.service.system.menu.MenuServiceI;
import com.stopboot.admin.utils.BeansHelper;
import com.stopboot.admin.utils.MenuListToTreeUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @version:0.0.1
 * @author: Lianyutao
 * @create: 2019-10-28 18:51
 * @description:
 **/

@Service
public class PermissionServiceImpl implements PermissionServiceI {

    @Resource
    private MenuServiceI menuServiceI;

    @Resource
    private SbMenuPermissionsMapper sbMenuPermissionsMapper;


    /**
     * 获得全部菜单 包括删除的，冻结的
     *
     * @param params
     * @return
     */
    @Override
    public List<PermissionMenuListVO> permissionMenuList(PermissionMenuListParams params) {
        List<SbMenu> sbMenuList = menuServiceI.getAllMenus();
        List<PermissionMenuListVO> menuLists = BeansHelper.getInstance().convert(sbMenuList, PermissionMenuListVO.class);
        for (PermissionMenuListVO menuListVO : menuLists) {
            //一下节点不能加权限
            if ("Layout".equals(menuListVO.getComponent()) || "Empty".equals(menuListVO.getComponent()) || "0".equals(menuListVO.getPid())) {
                menuListVO.setFlag(false);
            }
            //根据menuid获得当前菜单对应的权限列表
            SbMenuPermissionsExample example = new SbMenuPermissionsExample();
            SbMenuPermissionsExample.Criteria criteria = example.createCriteria();
            criteria.andMenuIdEqualTo(menuListVO.getId());
            List<SbMenuPermissions> sbMenuPermissions = sbMenuPermissionsMapper.selectByExample(example);
            List<String> permissionTags = sbMenuPermissions.stream().map(SbMenuPermissions::getTag).collect(Collectors.toList());
            menuListVO.setPermissions(permissionTags);
        }
        List<PermissionMenuListVO> permissionMenuListVOList = MenuListToTreeUtil.getInstance().listToTree(menuLists);
        if (permissionMenuListVOList != null && permissionMenuListVOList.size() > 0) {
            return permissionMenuListVOList;
        } else {
            return null;
        }
    }

    @Override
    public boolean add(PermissionAddParams params) {
        return false;
    }
}
