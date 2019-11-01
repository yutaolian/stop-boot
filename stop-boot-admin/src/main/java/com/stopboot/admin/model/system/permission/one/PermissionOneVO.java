package com.stopboot.admin.model.system.permission.one;

import com.stopboot.admin.base.vo.BaseVO;
import lombok.Data;


/**
 * @description:  Permission service
 * @author: Lianyutao
 * @create: 2019/10/29 19:16
 * @version: 1.0.1
 **/

@Data
public class PermissionOneVO extends BaseVO {

    /**
    *
    *
    */
    private Integer id;
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
