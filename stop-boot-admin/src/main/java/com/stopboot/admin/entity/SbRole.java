package com.stopboot.admin.entity;

import java.io.Serializable;
import java.util.Date;

public class SbRole implements Serializable {
    /**
     * 
     */
    private Integer id;

    /**
     * 角色名称
     */
    private String name;

    /**
     * 描述
     */
    private String description;

    /**
     * 角色标签
     */
    private String tag;

    /**
     * 状态（1正常使用，0不使用）
     */
    private Integer status;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 操作者id
     */
    private Integer opUserId;

    /**
     * 删除标识（0删除，1未删除）
     */
    private Integer deleteFlag;

    /**
     * sb_role
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
     * 角色名称
     * @return name 角色名称
     */
    public String getName() {
        return name;
    }

    /**
     * 角色名称
     * @param name 角色名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 描述
     * @return description 描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 描述
     * @param description 描述
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * 角色标签
     * @return tag 角色标签
     */
    public String getTag() {
        return tag;
    }

    /**
     * 角色标签
     * @param tag 角色标签
     */
    public void setTag(String tag) {
        this.tag = tag == null ? null : tag.trim();
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
     * 删除标识（0删除，1未删除）
     * @return delete_flag 删除标识（0删除，1未删除）
     */
    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    /**
     * 删除标识（0删除，1未删除）
     * @param deleteFlag 删除标识（0删除，1未删除）
     */
    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", description=").append(description);
        sb.append(", tag=").append(tag);
        sb.append(", status=").append(status);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", opUserId=").append(opUserId);
        sb.append(", deleteFlag=").append(deleteFlag);
        sb.append("]");
        return sb.toString();
    }
}