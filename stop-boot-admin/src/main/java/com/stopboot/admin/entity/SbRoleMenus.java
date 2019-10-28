package com.stopboot.admin.entity;

import java.io.Serializable;

public class SbRoleMenus implements Serializable {
    private Integer id;

    private Integer roldId;

    private Integer menuId;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoldId() {
        return roldId;
    }

    public void setRoldId(Integer roldId) {
        this.roldId = roldId;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", roldId=").append(roldId);
        sb.append(", menuId=").append(menuId);
        sb.append("]");
        return sb.toString();
    }
}