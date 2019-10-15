package com.stopboot.admin.model.menu.list;

import com.stopboot.admin.base.BaseVO;
import lombok.Data;

import java.util.List;

/**
 * @description: 菜单
 * @author: Lianyutao
 * @create: 2019-09-11 11:51
 * @version:
 **/
@Data
public class MenuListVO extends BaseVO {

    private Integer id;
    private Integer pid;
    private String path;
    private String component;
    private String name;
    private String icon;
    private String title;
    private Integer hidden;
    private List<MenuListVO> children;
}
