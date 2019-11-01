package com.stopboot.admin.model.system.permission.add;

import com.stopboot.admin.base.params.BaseAddParams;
import lombok.Data;

/**
 * @description:
 * @author: Lianyutao
 * @create: 2019/10/29 19:16
 * @version: 1.0.1
 **/

@Data
public class PermissionAddParams extends BaseAddParams{
    /**
     *菜单id
     *
     */
    private Integer menuId;
    /**
     *权限tag
     *
     */
    private String tag;
    /**
     *权限tag名称
     *
     */
    private String tagName;
    /**
     *权限tag描述
     *
     */
    private String tagDesc;

    /**
     * 当前权限的接口地址
     */
    private String url;
}
