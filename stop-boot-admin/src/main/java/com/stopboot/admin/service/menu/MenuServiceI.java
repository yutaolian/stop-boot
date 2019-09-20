package com.stopboot.admin.service.menu;

import com.stopboot.admin.base.BaseServiceI;
import com.stopboot.admin.entity.SbMenu;
import com.stopboot.admin.entity.SbMenuExample;
import com.stopboot.admin.model.menu.tree.MenuTree;
import com.stopboot.admin.model.menu.tree.MenuTreeParams;

import java.util.List;

public interface MenuServiceI extends BaseServiceI<SbMenu, SbMenuExample> {

    List<MenuTree> getMenuTree(MenuTreeParams params);

}
