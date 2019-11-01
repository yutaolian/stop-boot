package com.stopboot.admin.service.system.menu;

import com.stopboot.admin.base.service.DefaultServiceI;
import com.stopboot.admin.dto.MenuInfo;
import com.stopboot.admin.entity.SbMenu;
import com.stopboot.admin.model.system.menu.add.MenuAddParams;
import com.stopboot.admin.model.system.menu.list.MenuListVO;
import com.stopboot.admin.model.system.menu.list.MenuListParams;
import com.stopboot.admin.model.system.menu.one.MenuOneParams;
import com.stopboot.admin.model.system.menu.one.MenuOneVO;
import com.stopboot.admin.model.system.menu.page.MenuPageParams;
import com.stopboot.admin.model.system.menu.page.MenuPageVO;
import com.stopboot.admin.model.system.menu.update.MenuUpdateParams;
import com.stopboot.admin.model.system.menu.delete.MenuDeleteParams;

import java.util.List;


public interface MenuServiceI extends DefaultServiceI<MenuPageVO, MenuListVO, MenuOneVO,
        MenuPageParams, MenuListParams, MenuOneParams,
        MenuAddParams, MenuUpdateParams, MenuDeleteParams> {


    /**
     * 根据menuId获得当前节点及全部父节点
     * @param menuId
     * @return
     */
    MenuInfo getAllMenuInfoById(Integer menuId);

    /**
     * 获得全部菜单
     * @return
     */
    List<SbMenu> getAllMenus(List<Integer> ids);

    /**
     * 获得全部菜单
     * @return
     */
    List<SbMenu> getAllShowMenus();

}
