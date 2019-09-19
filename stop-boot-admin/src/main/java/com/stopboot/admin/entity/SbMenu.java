package com.stopboot.admin.entity;

import java.io.Serializable;
import java.util.Date;

public class SbMenu implements Serializable {
    /**
     * 
     */
    private Integer id;

    /**
     * 父id
     */
    private Integer pid;

    /**
     * 菜单编码
     */
    private String code;

    /**
     * 菜单名称
     */
    private String title;

    /**
     * 菜单点击路径
     */
    private String path;

    /**
     * 类型 （1内部菜单，-1外部链接）
     */
    private Integer type;

    /**
     * 链接地址
     */
    private String link;

    /**
     * 排序按从小到大排序（0最靠前）
     */
    private Integer sort;

    /**
     * 状态（1正常使用，0不使用）
     */
    private Integer status;

    /**
     * icon
     */
    private String icon;

    /**
     * 删除标识（0删除，1正常）
     */
    private Integer deleteFlag;

    /**
     * 操作者id
     */
    private Integer opUserId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * sb_menu
     */
    private static final long serialVersionUID = 1L;

    /**
     * 
     * @return id 
     */
    public Integer getId() {
        return id;
    }

    /**
     * 
     * @param id 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 父id
     * @return pid 父id
     */
    public Integer getPid() {
        return pid;
    }

    /**
     * 父id
     * @param pid 父id
     */
    public void setPid(Integer pid) {
        this.pid = pid;
    }

    /**
     * 菜单编码
     * @return code 菜单编码
     */
    public String getCode() {
        return code;
    }

    /**
     * 菜单编码
     * @param code 菜单编码
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * 菜单名称
     * @return title 菜单名称
     */
    public String getTitle() {
        return title;
    }

    /**
     * 菜单名称
     * @param title 菜单名称
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * 菜单点击路径
     * @return path 菜单点击路径
     */
    public String getPath() {
        return path;
    }

    /**
     * 菜单点击路径
     * @param path 菜单点击路径
     */
    public void setPath(String path) {
        this.path = path == null ? null : path.trim();
    }

    /**
     * 类型 （1内部菜单，-1外部链接）
     * @return type 类型 （1内部菜单，-1外部链接）
     */
    public Integer getType() {
        return type;
    }

    /**
     * 类型 （1内部菜单，-1外部链接）
     * @param type 类型 （1内部菜单，-1外部链接）
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 链接地址
     * @return link 链接地址
     */
    public String getLink() {
        return link;
    }

    /**
     * 链接地址
     * @param link 链接地址
     */
    public void setLink(String link) {
        this.link = link == null ? null : link.trim();
    }

    /**
     * 排序按从小到大排序（0最靠前）
     * @return sort 排序按从小到大排序（0最靠前）
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 排序按从小到大排序（0最靠前）
     * @param sort 排序按从小到大排序（0最靠前）
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     * 状态（1正常使用，0不使用）
     * @return status 状态（1正常使用，0不使用）
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 状态（1正常使用，0不使用）
     * @param status 状态（1正常使用，0不使用）
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * icon
     * @return icon icon
     */
    public String getIcon() {
        return icon;
    }

    /**
     * icon
     * @param icon icon
     */
    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    /**
     * 删除标识（0删除，1正常）
     * @return delete_flag 删除标识（0删除，1正常）
     */
    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    /**
     * 删除标识（0删除，1正常）
     * @param deleteFlag 删除标识（0删除，1正常）
     */
    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    /**
     * 操作者id
     * @return op_user_id 操作者id
     */
    public Integer getOpUserId() {
        return opUserId;
    }

    /**
     * 操作者id
     * @param opUserId 操作者id
     */
    public void setOpUserId(Integer opUserId) {
        this.opUserId = opUserId;
    }

    /**
     * 创建时间
     * @return create_time 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 更新时间
     * @return update_time 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 更新时间
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", pid=").append(pid);
        sb.append(", code=").append(code);
        sb.append(", title=").append(title);
        sb.append(", path=").append(path);
        sb.append(", type=").append(type);
        sb.append(", link=").append(link);
        sb.append(", sort=").append(sort);
        sb.append(", status=").append(status);
        sb.append(", icon=").append(icon);
        sb.append(", deleteFlag=").append(deleteFlag);
        sb.append(", opUserId=").append(opUserId);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append("]");
        return sb.toString();
    }
}