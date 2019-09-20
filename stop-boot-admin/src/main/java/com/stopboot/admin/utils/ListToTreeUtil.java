package com.stopboot.admin.utils;

import com.stopboot.admin.model.menu.tree.MenuTree;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: Lianyutao
 * @create: 2019-08-14 20:08
 * @version: list结构转成tree
 **/

public class ListToTreeUtil {
    public static List<MenuTree> menuListToTree(List<MenuTree> treeList) {
        List<MenuTree> dataList = new ArrayList<>();
        for (MenuTree parent : treeList) {
            if (parent.getPid().equals(0)) {
                dataList.add(parent);
            }
            for (MenuTree child : treeList) {
                if (child.getPid() == parent.getId()) {
                    if (parent.getChildren() == null) {
                        parent.setChildren(new ArrayList<>());
                    }
                    parent.getChildren().add(child);
                }
            }
        }
        return dataList;
    }
}
