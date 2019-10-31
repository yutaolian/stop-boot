package com.stopboot.admin.service.system.menu;

import com.stopboot.admin.dto.MenuInfo;
import com.stopboot.admin.entity.SbMenu;
import com.stopboot.admin.model.menu.list.MenuListParams;
import com.stopboot.admin.model.menu.list.MenuListVO;

import java.util.List;

/**
 * @description:
 * @author: Lianyutao
 * @create: 2019-09-19 11:18
 * @version:
 **/
public interface MenuServiceI {


    List<MenuListVO> list(MenuListParams params);

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
