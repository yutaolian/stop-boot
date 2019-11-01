package com.stopboot.admin.service.system.permission;

import com.stopboot.admin.base.service.DefaultServiceImpl;
import com.stopboot.admin.dto.MenuInfo;
import com.stopboot.admin.entity.SbMenu;
import com.stopboot.admin.mapper.mybatis.SbMenuPermissionsMapper;
import com.stopboot.admin.entity.SbMenuPermissions;
import com.stopboot.admin.entity.SbMenuPermissionsExample;
import com.stopboot.admin.model.help.generator.GeneratorInfo;
import com.stopboot.admin.model.system.permission.add.PermissionAddParams;
import com.stopboot.admin.model.system.permission.list.PermissionInfoVO;
import com.stopboot.admin.model.system.permission.list.PermissionListParams;
import com.stopboot.admin.model.system.permission.list.PermissionListVO;
import com.stopboot.admin.model.system.permission.one.PermissionOneParams;
import com.stopboot.admin.model.system.permission.one.PermissionOneVO;
import com.stopboot.admin.model.system.permission.page.PermissionPageParams;
import com.stopboot.admin.model.system.permission.page.PermissionPageVO;
import com.stopboot.admin.model.system.permission.update.PermissionUpdateParams;
import com.stopboot.admin.model.system.permission.delete.PermissionDeleteParams;
import com.stopboot.admin.service.system.menu.MenuServiceI;
import com.stopboot.admin.utils.BeansHelper;
import com.stopboot.admin.utils.MenuListToTreeUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: Permission service
 * @author: Lianyutao
 * @create: 2019/10/29 19:16
 * @version: 1.0.1
 **/

@Slf4j
@Service
public class PermissionServiceImpl extends DefaultServiceImpl<SbMenuPermissionsMapper, SbMenuPermissions, SbMenuPermissionsExample,
        PermissionPageVO, PermissionListVO, PermissionOneVO,
        PermissionPageParams, PermissionListParams, PermissionOneParams,
        PermissionAddParams, PermissionUpdateParams, PermissionDeleteParams>
        implements PermissionServiceI {

    @Resource
    private MenuServiceI menuService;


    @Override
    public boolean add(PermissionAddParams params) {


        return false;
    }

    @Override
    public List<PermissionListVO> list(PermissionListParams params) {
        List<SbMenu> sbMenuList = menuService.getAllShowMenus();
        List<PermissionListVO> menuLists = BeansHelper.getInstance().convert(sbMenuList, PermissionListVO.class);
        for (PermissionListVO menuListVO : menuLists) {
            //根节点或空节点不能加权限
            if ("Layout".equals(menuListVO.getComponent()) || "Empty".equals(menuListVO.getComponent()) || 0 == menuListVO.getPid()) {
                menuListVO.setFlag(false);
                menuListVO.setFullPath("");
            } else {
                menuListVO.setFlag(true);
                //根据menuid获得当前菜单对应的权限列表
                SbMenuPermissionsExample example = new SbMenuPermissionsExample();
                SbMenuPermissionsExample.Criteria criteria = example.createCriteria();
                criteria.andMenuIdEqualTo(menuListVO.getId());
                List<SbMenuPermissions> sbMenuPermissions = this.selectByExample(example);
                if (sbMenuPermissions.size() > 0) {
                    List<PermissionInfoVO> permissionInfoVOList = BeansHelper.getInstance().convert(sbMenuPermissions, PermissionInfoVO.class);
                    menuListVO.setPermissions(permissionInfoVOList);
                } else {
                    menuListVO.setPermissions(new ArrayList<>());
                }
                MenuInfo menuInfo = menuService.getAllMenuInfoById(menuListVO.getId());
                menuListVO.setFullPath(menuInfo.getFullPath());
            }
        }
        List<PermissionListVO> permissionMenuListVOList = MenuListToTreeUtil.getInstance().listToTree(menuLists);
        if (permissionMenuListVOList != null && permissionMenuListVOList.size() > 0) {
            return permissionMenuListVOList;
        } else {
            return null;
        }
    }

    /**
     * 生成默认权限
     * "page", "list", "one", "add", "update", "delete" 五个
     *
     * @param generatorInfo
     */
    @Override
    public void addGeneratorPermission(GeneratorInfo generatorInfo) {
        Integer menuId = generatorInfo.getMenuId();
        String fullPath = generatorInfo.getFullPath();
        String title = generatorInfo.getTitle();
        String fullPathToPermission = generatorInfo.getFullPathToPermission();

        List<String> tags = Arrays.asList("page", "list", "one", "add", "update", "delete");
        List<String> tagsNames = Arrays.asList("分页", "列表", "详情", "添加", "修改", "删除");
        for (int i = 0; i < tags.size(); i++) {
            String tag = tags.get(i);
            //删掉原有标签
            SbMenuPermissionsExample sbMenuPermissionsExample = new SbMenuPermissionsExample();
            SbMenuPermissionsExample.Criteria criteria = sbMenuPermissionsExample.createCriteria();
            criteria.andMenuIdEqualTo(menuId);
            criteria.andTagEqualTo(fullPathToPermission + "_" + tag.toUpperCase());
            this.deleteByExample(sbMenuPermissionsExample);

            SbMenuPermissions sbMenuPermissions = new SbMenuPermissions();
            sbMenuPermissions.setMenuId(menuId);
            sbMenuPermissions.setTagName(title + "_" + tagsNames.get(i));
            sbMenuPermissions.setTag(fullPathToPermission + "_" + tag.toUpperCase());
            sbMenuPermissions.setTagDesc("默认生成" + title + "_" + tag + "权限标签");
            sbMenuPermissions.setUrl(fullPath + "/" + tag);
            this.insertSelective(sbMenuPermissions);
        }

    }
}
