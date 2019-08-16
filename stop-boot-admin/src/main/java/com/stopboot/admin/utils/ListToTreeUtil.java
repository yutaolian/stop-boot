package com.stopboot.admin.utils;

import com.alibaba.fastjson.JSON;
import com.stopboot.admin.model.menu.Menu;
import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: Lianyutao
 * @create: 2019-08-14 20:08
 * @version: list结构转成tree
 **/

public class ListToTreeUtil {


    public static void main(String[] args) {

        List<Menu> arrays = new ArrayList<>();

        {
            Menu menu = new Menu();
            menu.setId(1);
            menu.setPId(0);
            menu.setName("R");
            arrays.add(menu);
        }

        {
            Menu menu = new Menu();
            menu.setId(2);
            menu.setPId(1);
            menu.setName("A");
            arrays.add(menu);
        }

        {
            Menu menu = new Menu();
            menu.setId(3);
            menu.setPId(2);
            menu.setName("A1");
            arrays.add(menu);
        }
        {
            Menu menu = new Menu();
            menu.setId(4);
            menu.setPId(2);
            menu.setName("A2");
            arrays.add(menu);
        }

        {
            Menu menu = new Menu();
            menu.setId(5);
            menu.setPId(1);
            menu.setName("B");
            arrays.add(menu);
        }

        {
            Menu menu = new Menu();
            menu.setId(6);
            menu.setPId(5);
            menu.setName("B1");
            arrays.add(menu);
        }
        {
            Menu menu = new Menu();
            menu.setId(7);
            menu.setPId(5);
            menu.setName("B2");
            arrays.add(menu);
        }

        List<Menu> menus = menuListToTree(arrays);
        System.out.println(JSON.toJSONString(menus));

        //[
        //  {
        //    "id": 1,
        //    "name": "R",
        //    "pId": 0,
        //    "subMenus": [
        //      {
        //        "id": 2,
        //        "name": "A",
        //        "pId": 1,
        //        "subMenus": [
        //          {
        //            "id": 3,
        //            "name": "A1",
        //            "pId": 2
        //          },
        //          {
        //            "id": 4,
        //            "name": "A2",
        //            "pId": 2
        //          }
        //        ]
        //      },
        //      {
        //        "id": 5,
        //        "name": "B",
        //        "pId": 1,
        //        "subMenus": [
        //          {
        //            "id": 6,
        //            "name": "B1",
        //            "pId": 5
        //          },
        //          {
        //            "id": 7,
        //            "name": "B2",
        //            "pId": 5
        //          }
        //        ]
        //      }
        //    ]
        //  }
        //]
    }


    public static List<Menu> menuListToTree(List<Menu> treeList) {
        List<Menu> retList = new ArrayList<>();
        for (Menu parent : treeList) {
            if (parent.getPId().equals(0)) {
                retList.add(parent);
            }
            for (Menu child : treeList) {
                if (child.getPId() == parent.getId()) {
                    if (parent.getSubMenus() == null) {
                        parent.setSubMenus(new ArrayList<>());
                    }
                    parent.getSubMenus().add(child);
                }
            }
        }
        return retList;
    }
}
