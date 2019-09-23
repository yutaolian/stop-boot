package com.stopboot.admin.utils;

import com.stopboot.admin.model.menu.list.MenuListVO;
import com.stopboot.admin.model.menu.tree.MenuTreeVO;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: Lianyutao
 * @create: 2019-08-14 20:08
 * @version: list结构转成tree
 **/

public class ListToTreeUtil {
    public static List<MenuTreeVO> menuListToTree(List<MenuTreeVO> treeList) {
        List<MenuTreeVO> dataList = new ArrayList<>();
        for (MenuTreeVO parent : treeList) {
            if (parent.getPid().equals(0)) {
                dataList.add(parent);
            }
            for (MenuTreeVO child : treeList) {
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

    public static List<MenuListVO> menuListToTree2(List<MenuListVO> treeList) {
        List<MenuListVO> dataList = new ArrayList<>();
        for (MenuListVO parent : treeList) {
            if (parent.getPid().equals(0)) {
                dataList.add(parent);
            }
            for (MenuListVO child : treeList) {
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
