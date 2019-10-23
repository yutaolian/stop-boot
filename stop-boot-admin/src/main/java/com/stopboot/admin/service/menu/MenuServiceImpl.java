package com.stopboot.admin.service.menu;

import com.stopboot.admin.base.params.*;
import com.stopboot.admin.base.service.DefaultListServiceImpl;
import com.stopboot.admin.base.vo.BaseVO;
import com.stopboot.admin.dao.mybatis.mapper.SbMenuMapper;
import com.stopboot.admin.dto.MenuInfo;
import com.stopboot.admin.entity.SbMenu;
import com.stopboot.admin.entity.SbMenuExample;
import com.stopboot.admin.model.menu.add.MenuAddParams;
import com.stopboot.admin.model.menu.list.MenuListParams;
import com.stopboot.admin.model.menu.list.MenuListVO;
import com.stopboot.admin.utils.BeansHelper;
import com.stopboot.admin.utils.ListToTreeUtil;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @description:
 * @author: Lianyutao
 * @create: 2019-09-19 11:18
 * @version:
 **/

@Service
public class MenuServiceImpl extends DefaultListServiceImpl<SbMenuMapper, SbMenu, SbMenuExample, BaseVO, MenuListVO,
        BaseVO, BasePageParams, MenuListParams, BaseOneParams, MenuAddParams, BaseUpdateParams,BaseDeleteParams> implements MenuServiceI {

    @Override
    public List<MenuListVO> list(MenuListParams params) {
        SbMenuExample sbMenuExample = new SbMenuExample();
        sbMenuExample.setOrderByClause(" pid , sort ,id ");
        SbMenuExample.Criteria criteria = sbMenuExample.createCriteria();
        criteria.andDeleteFlagEqualTo(1);
        criteria.andStatusEqualTo(1);
        List<SbMenu> sbMenuList = this.selectByExample(sbMenuExample);
        List<MenuListVO> menuLists = BeansHelper.getInstance().convert(sbMenuList, MenuListVO.class);
        List<MenuListVO> menuListVOList = ListToTreeUtil.listToTree(menuLists);
        if (menuListVOList != null && menuListVOList.size() > 0) {
            return menuListVOList;
        } else {
            return null;
        }
    }


    @Override
    public MenuInfo getAllMenuInfoById(Integer menuId) {
        return getAllParentNode(menuId);
    }

    private MenuInfo getAllParentNode(Integer menuId) {
        SbMenu menu = this.oneFromDB(menuId);
        MenuInfo menuInfo = (MenuInfo) BeansHelper.getInstance().convert(menu, MenuInfo.class);
        if (1 != menu.getPid()) {
            menuInfo.setParent(getAllParentNode(menuInfo.getPid()));
        }
        return menuInfo;
    }


}
