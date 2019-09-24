package com.stopboot.admin.utils;

import com.stopboot.admin.model.menu.list.MenuListVO;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: Lianyutao
 * @create: 2019-08-14 20:08
 * @version: list结构转成tree
 **/

public class ListToTreeUtil {
    /**
     * 递归处理
     *
     * @param list
     * @return
     */
    public static List<MenuListVO> listToTree(List<MenuListVO> list) {
        List<MenuListVO> treeList = new ArrayList<>();
        for (MenuListVO tree : list) {
            if (tree.getPid() == 0) {
                treeList.add(findChildren(tree, list));
            }
        }
        return treeList;
    }

    private static MenuListVO findChildren(MenuListVO tree, List<MenuListVO> list) {
        for (MenuListVO node : list) {
            if (node.getPid() == tree.getId()) {
                if (tree.getChildren() == null) {
                    tree.setChildren(new ArrayList<>());
                }
                tree.getChildren().add(findChildren(node, list));
            }
        }
        return tree;
    }

}
