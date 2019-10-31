package com.stopboot.admin.entity;

import java.io.Serializable;

public class SbRoleMenuPermissions implements Serializable {
    private Integer id;

    private Integer roleId;

    private Integer menuPermissionId;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getMenuPermissionId() {
        return menuPermissionId;
    }

    public void setMenuPermissionId(Integer menuPermissionId) {
        this.menuPermissionId = menuPermissionId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", roleId=").append(roleId);
        sb.append(", menuPermissionId=").append(menuPermissionId);
        sb.append("]");
        return sb.toString();
    }
}