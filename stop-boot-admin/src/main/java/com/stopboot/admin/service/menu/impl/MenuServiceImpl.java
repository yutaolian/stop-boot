package com.stopboot.admin.service.menu.impl;

import com.stopboot.admin.base.BaseServiceImpl;
import com.stopboot.admin.dao.mybatis.mapper.SbMenuMapper;
import com.stopboot.admin.entity.SbMenu;
import com.stopboot.admin.entity.SbMenuExample;
import com.stopboot.admin.model.menu.list.MenuListVO;
import com.stopboot.admin.model.menu.list.MenuListVOParams;
import com.stopboot.admin.model.menu.tree.MenuTreeVOParams;
import com.stopboot.admin.model.menu.tree.MenuTreeVO;
import com.stopboot.admin.service.menu.MenuServiceI;
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
public class MenuServiceImpl extends BaseServiceImpl<SbMenuMapper, SbMenu, SbMenuExample> implements MenuServiceI {

    @Override
    public List<MenuListVO> getMenuList(MenuListVOParams params) {
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
}
