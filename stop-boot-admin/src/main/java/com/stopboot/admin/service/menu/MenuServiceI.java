package com.stopboot.admin.service.menu;

import com.stopboot.admin.base.BaseServiceI;
import com.stopboot.admin.entity.SbMenu;
import com.stopboot.admin.entity.SbMenuExample;
import com.stopboot.admin.model.menu.list.MenuListVO;
import com.stopboot.admin.model.menu.list.MenuListVOParams;
import com.stopboot.admin.model.menu.tree.MenuTreeVOParams;
import com.stopboot.admin.model.menu.tree.MenuTreeVO;

import java.util.List;

    public interface MenuServiceI extends BaseServiceI<SbMenu, SbMenuExample> {

        List<MenuTreeVO> getMenuTree(MenuTreeVOParams params);

        List<MenuListVO> getMenuList(MenuListVOParams params);
    }
