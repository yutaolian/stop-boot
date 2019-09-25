package com.stopboot.admin.model.menu.tree;

import lombok.Data;

import java.util.List;

/**
 * @description: 菜单
 * @author: Lianyutao
 * @create: 2019-09-11 11:51
 * @version:
 **/
@Data
public class MenuTreeVO {

    /**
     * path : /course
     * component : Layout
     * name : course
     * children : [{"path":"list","component":"course/list","name":"courseList","icon":"user","title":"课程列表"}]
     * icon : index
     * title : 课程管理
     * hidden : false
     */

    private Integer id;
    private  Integer pid;
    private String path;
    private String component;
    private String name;
    private String icon;
    private String title;
    private Integer hidden;
    private List<MenuTreeVO> children;

}
