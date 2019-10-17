package com.stopboot.admin.service.menu;

import com.stopboot.admin.base.params.*;
import com.stopboot.admin.base.service.DefaultListServiceI;
import com.stopboot.admin.base.vo.BaseVO;
import com.stopboot.admin.model.menu.add.MenuAddParams;
import com.stopboot.admin.model.menu.list.MenuListParams;
import com.stopboot.admin.model.menu.list.MenuListVO;

/**
 * @description:
 * @author: Lianyutao
 * @create: 2019-09-19 11:18
 * @version:
 **/
public interface MenuServiceI extends DefaultListServiceI<BaseVO, MenuListVO, BaseVO, BasePageParams, MenuListParams, BaseOneParams, MenuAddParams, BaseUpdateParams> {

}
