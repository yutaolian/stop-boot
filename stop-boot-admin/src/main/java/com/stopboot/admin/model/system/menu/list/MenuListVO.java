package com.stopboot.admin.model.system.menu.list;

import com.stopboot.admin.base.vo.BaseMenuTreeVO;
import lombok.Data;

import java.util.List;


/**
 * @description:  Menu service
 * @author: Lianyutao
 * @create: 2019/11/01 16:50
 * @version: 1.0.1
 **/

@Data
public class MenuListVO extends BaseMenuTreeVO {


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
     * 菜单权限李彪
     */
    private List<String> permissions;

}
