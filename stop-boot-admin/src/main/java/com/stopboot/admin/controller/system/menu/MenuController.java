package com.stopboot.admin.controller.system.menu;

import com.stopboot.admin.base.controller.DefaultListController;
import com.stopboot.admin.base.params.*;
import com.stopboot.admin.base.vo.BaseVO;
import com.stopboot.admin.model.menu.add.MenuAddParams;
import com.stopboot.admin.model.menu.list.MenuListParams;
import com.stopboot.admin.model.menu.list.MenuListVO;
import com.stopboot.admin.service.menu.MenuServiceI;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @description: 菜单
 * @author: Lianyutao
 * @create: 2019-09-19 11:17
 * @version:
 **/

@Slf4j
@RestController
@RequestMapping("system/menu")
public class MenuController extends DefaultListController<MenuServiceI, BaseVO, MenuListVO, BaseVO, BasePageParams, MenuListParams, BaseOneParams, MenuAddParams, BaseUpdateParams,BaseDeleteParams> {


}
