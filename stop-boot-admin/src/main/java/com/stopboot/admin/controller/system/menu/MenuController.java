package com.stopboot.admin.controller.system.menu;

import com.stopboot.admin.base.controller.DefaultController;
import com.stopboot.admin.model.system.menu.add.MenuAddParams;
import com.stopboot.admin.model.system.menu.list.MenuListParams;
import com.stopboot.admin.model.system.menu.list.MenuListVO;
import com.stopboot.admin.model.system.menu.one.MenuOneParams;
import com.stopboot.admin.model.system.menu.one.MenuOneVO;
import com.stopboot.admin.model.system.menu.page.MenuPageParams;
import com.stopboot.admin.model.system.menu.page.MenuPageVO;
import com.stopboot.admin.model.system.menu.update.MenuUpdateParams;
import com.stopboot.admin.model.system.menu.delete.MenuDeleteParams;
import com.stopboot.admin.service.system.menu.MenuServiceI;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: Lianyutao
 * @create: 2019/11/01 16:50
 * @version: 1.0.1
 **/

@Slf4j
@RestController
@RequestMapping("/system/menu")
public class MenuController extends DefaultController<MenuServiceI,
        MenuPageVO,MenuListVO,MenuOneVO,
        MenuPageParams, MenuListParams,  MenuOneParams,
        MenuAddParams, MenuUpdateParams, MenuDeleteParams> {


}
