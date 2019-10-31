package com.stopboot.admin.model.system.permission.list;

import com.stopboot.admin.base.params.BaseListParams;
import lombok.Data;

/**
 * @description:
 * @author: Lianyutao
 * @create: 2019/10/29 19:16
 * @version: 1.0.1
 **/

@Data
public class PermissionListParams extends BaseListParams{
    /**
     *角色id
     *
     */
    private Integer roleId;

}
