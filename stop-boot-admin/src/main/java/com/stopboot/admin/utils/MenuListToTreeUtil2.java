package com.stopboot.admin.utils;

import com.stopboot.admin.base.vo.BaseMenuTreeVO;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: Lianyutao
 * @create: 2019-08-14 20:08
 * @version: list结构转成tree
 **/

public class MenuListToTreeUtil2<MenuVO extends BaseMenuTreeVO> {

    private MenuListToTreeUtil2() {
    }

    private static class MenuListToTreeUtilInstance {
        private static final MenuListToTreeUtil2 INSTANCE = new MenuListToTreeUtil2();
    }

    public static MenuListToTreeUtil2 getInstance() {
        return MenuListToTreeUtilInstance.INSTANCE;
    }

    /**
     * 递归处理
     *
     * @param list
     * @return
     */
    public List<MenuVO> listToTree(List<MenuVO> list) {
        List<MenuVO> treeList = new ArrayList<>();
        if (list == null || list.size() == 0) {
            return null;
        }
        for (MenuVO tree : list) {
            if (tree.getPid() == 0) {
                treeList.add(findChildren(tree, list));
            }
        }
        return treeList;
    }

    private MenuVO findChildren(MenuVO tree, List<MenuVO> list) {
        for (MenuVO node : list) {
            if (node.getPid().equals(tree.getId())) {
                if (null == tree.getChildren()) {
                    tree.setChildren(new ArrayList<>());
                }
                if (!node.getPath().startsWith("http")) {
                    if (tree.getPath().equals("/")) {
                        node.setPath(tree.getPath() + node.getPath());
                    } else {
                        node.setPath(tree.getPath() + "/" + node.getPath());
                    }
                } else {
                    node.setPath(node.getPath());
                }
                tree.getChildren().add(findChildren(node, list));
            }
        }
        return tree;
    }

}
