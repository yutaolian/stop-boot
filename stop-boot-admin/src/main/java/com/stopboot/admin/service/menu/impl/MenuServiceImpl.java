package com.stopboot.admin.service.menu.impl;

import com.stopboot.admin.base.BaseServiceImpl;
import com.stopboot.admin.dao.mybatis.mapper.SbMenuMapper;
import com.stopboot.admin.entity.SbMenu;
import com.stopboot.admin.entity.SbMenuExample;
import com.stopboot.admin.model.menu.tree.MenuTree;
import com.stopboot.admin.model.menu.tree.MenuTreeParams;
import com.stopboot.admin.service.menu.MenuServiceI;
import com.stopboot.admin.utils.BeansHelper;
import com.stopboot.admin.utils.ListToTreeUtil;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


/**
 * @description:
 * @author: Lianyutao
 * @create: 2019-09-19 11:18
 * @version:
 **/

@Service
public class MenuServiceImpl extends BaseServiceImpl<SbMenuMapper, SbMenu, SbMenuExample> implements MenuServiceI {

    @Override
    public List<MenuTree> getMenuTree(MenuTreeParams params) {
        SbMenuExample sbMenuExample = new SbMenuExample();
        sbMenuExample.setOrderByClause(" pid , sort ,id ");
        SbMenuExample.Criteria criteria = sbMenuExample.createCriteria();
        criteria.andDeleteFlagEqualTo(1);
        criteria.andStatusEqualTo(1);
        List<SbMenu> sbMenuList = this.selectByExample(sbMenuExample);
        List<MenuTree> menuTrees = BeansHelper.getInstance().convert(sbMenuList, MenuTree.class);
        List<MenuTree> treeList = ListToTreeUtil.menuListToTree(menuTrees);
        if (treeList != null && treeList.size() > 0) {
            return treeList.get(0).getChildren();
        } else {
            return null;
        }
    }
}
