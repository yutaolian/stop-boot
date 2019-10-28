package com.stopboot.admin.service.system.menu;

import com.stopboot.admin.dto.MenuInfo;
import com.stopboot.admin.entity.SbMenu;
import com.stopboot.admin.entity.SbMenuExample;
import com.stopboot.admin.mapper.mybatis.SbMenuMapper;
import com.stopboot.admin.model.menu.list.MenuListParams;
import com.stopboot.admin.model.menu.list.MenuListVO;
import com.stopboot.admin.utils.BeansHelper;
import com.stopboot.admin.utils.MenuListToTreeUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


/**
 * @description:
 * @author: Lianyutao
 * @create: 2019-09-19 11:18
 * @version:
 **/

@Service
public class MenuServiceImpl implements MenuServiceI {

    @Resource
    private SbMenuMapper sbMenuMapper;


    @Override
    public List<SbMenu> getAllMenus() {
        SbMenuExample sbMenuExample = new SbMenuExample();
        sbMenuExample.setOrderByClause(" pid , sort ,id ");
        SbMenuExample.Criteria criteria = sbMenuExample.createCriteria();
        criteria.andDeleteFlagEqualTo(1);
        criteria.andStatusEqualTo(1);
        List<SbMenu> sbMenuList = sbMenuMapper.selectByExample(sbMenuExample);
        return sbMenuList;
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
        List<MenuListVO> menuLists = BeansHelper.getInstance().convert(getAllMenus(), MenuListVO.class);
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
        SbMenu menu = sbMenuMapper.selectByPrimaryKey(menuId);
        MenuInfo menuInfo = (MenuInfo) BeansHelper.getInstance().convert(menu, MenuInfo.class);
        if (1 != menu.getPid()) {
            menuInfo.setParent(getAllParentNode(fullPathArray, menuInfo.getPid()));
        }
        fullPathArray.add(menuInfo.getPath());
        return menuInfo;
    }


}
