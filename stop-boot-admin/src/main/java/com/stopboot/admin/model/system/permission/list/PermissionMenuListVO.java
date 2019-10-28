package com.stopboot.admin.model.system.permission.list;/**
 * @version:0.0.1
 * @author: Lianyutao
 * @create: 2019-10-28 18:50
 * @description: 权限列表实体
 **/

import com.stopboot.admin.base.vo.BaseMenuTreeVO;
import lombok.Data;

import java.util.List;

/**
 * @version:0.0.1
 * @author: Lianyutao
 * @create: 2019-10-28 18:50
 * @description: 权限列表实体
 **/

@Data
public class PermissionMenuListVO extends BaseMenuTreeVO {

    private String component;

    private String title;

    private Boolean flag;

    private List<String> permissions;

}
