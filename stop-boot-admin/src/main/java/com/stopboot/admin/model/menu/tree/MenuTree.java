package com.stopboot.admin.model.menu.tree;

import java.util.List;

/**
 * @description: 菜单
 * @author: Lianyutao
 * @create: 2019-09-11 11:51
 * @version:
 **/

public class MenuTree {

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
    private List<MenuTree> children;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getHidden() {
        return hidden;
    }

    public void setHidden(Integer hidden) {
        this.hidden = hidden;
    }

    public List<MenuTree> getChildren() {
        return children;
    }

    public void setChildren(List<MenuTree> children) {
        this.children = children;
    }
}
