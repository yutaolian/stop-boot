package com.stopboot.admin.model.system.menu.page;

import com.stopboot.admin.base.params.BasePageParams;
import lombok.Data;

/**
 * @description:
 * @author: Lianyutao
 * @create: 2019/11/01 16:50
 * @version: 1.0.1
 **/

@Data
public class MenuPageParams extends BasePageParams{
    /**
     *父id
     *
     */
    private Integer pid;
    /**
     *菜单名称(显示名字)
     *
     */
    private String title;
    /**
     *菜单名称
     *
     */
    private String name;
    /**
     *组件名称
     *
     */
    private String component;
    /**
     *菜单点击路径
     *
     */
    private String path;
    /**
     *icon
     *
     */
    private String icon;
    /**
     *类型 （1内部菜单，-1外部链接）
     *
     */
    private Integer type;
    /**
     *链接地址
     *
     */
    private String link;
    /**
     *菜单编码
     *
     */
    private String code;
    /**
     *是否显示 1 显示 0 隐藏
     *
     */
    private Integer hidden;
    /**
     *状态（1正常使用，0不使用）
     *
     */
    private Integer status;
    /**
     *排序按从小到大排序（0最靠前）
     *
     */
    private Integer sort;
    /**
     *删除标识（0删除，1正常）
     *
     */
    private Integer deleteFlag;
    /**
     *操作者id
     *
     */
    private Integer opUserId;
    /**
     *创建时间
     *
     */
    private java.util.Date createTime;
    /**
     *更新时间
     *
     */
    private java.util.Date updateTime;
}
