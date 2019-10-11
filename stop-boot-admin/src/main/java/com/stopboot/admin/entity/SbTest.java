package com.stopboot.admin.entity;

import java.io.Serializable;
import java.util.Date;

public class SbTest implements Serializable {
    /**
     * 
     */
    private Integer id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 生日
     */
    private Date birthday;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 头像
     */
    private String headImg;

    /**
     * 删除标记（1正常，0删除）
     */
    private Integer deleteFlag;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 信息
     */
    private String info;

    /**
     * sb_test
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
     * 姓名
     * @return name 姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 姓名
     * @param name 姓名
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 年龄
     * @return age 年龄
     */
    public Integer getAge() {
        return age;
    }

    /**
     * 年龄
     * @param age 年龄
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * 生日
     * @return birthday 生日
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * 生日
     * @param birthday 生日
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
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
     * 状态
     * @return status 状态
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 状态
     * @param status 状态
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 头像
     * @return head_img 头像
     */
    public String getHeadImg() {
        return headImg;
    }

    /**
     * 头像
     * @param headImg 头像
     */
    public void setHeadImg(String headImg) {
        this.headImg = headImg == null ? null : headImg.trim();
    }

    /**
     * 删除标记（1正常，0删除）
     * @return delete_flag 删除标记（1正常，0删除）
     */
    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    /**
     * 删除标记（1正常，0删除）
     * @param deleteFlag 删除标记（1正常，0删除）
     */
    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
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
     * 信息
     * @return info 信息
     */
    public String getInfo() {
        return info;
    }

    /**
     * 信息
     * @param info 信息
     */
    public void setInfo(String info) {
        this.info = info == null ? null : info.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", age=").append(age);
        sb.append(", birthday=").append(birthday);
        sb.append(", createTime=").append(createTime);
        sb.append(", status=").append(status);
        sb.append(", headImg=").append(headImg);
        sb.append(", deleteFlag=").append(deleteFlag);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", info=").append(info);
        sb.append("]");
        return sb.toString();
    }
}