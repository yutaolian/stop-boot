package com.stopboot.admin.model.menu.add;

import com.stopboot.admin.base.params.BaseAddParams;
import com.stopboot.admin.base.params.BaseParams;
import lombok.Data;


/**
 * @description:
 * @author: Lianyutao
 * @create: 2019-09-11 11:52
 * @version:
 **/

@Data
public class MenuAddParams extends BaseParams {

    private Integer pid;

    private String title;

    private String name;

    /**
     * vue组件名称
     */
    private String component;

    /**
     * 菜单点击路径
     */
    private String path;

    /**
     * icon
     */
    private String icon;

    /**
     * 类型 （1内部菜单，-1外部链接）
     */
    private Integer type;

    /**
     * 链接地址
     */
    private String link;

    /**
     * 是否显示 1 显示 0 隐藏
     */
    private Integer hidden;

    /**
     * 排序按从小到大排序（0最靠前）
     */
    private Integer sort;


}
