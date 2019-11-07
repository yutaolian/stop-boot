package com.stopboot.admin.model.system.permission.list;

import com.stopboot.admin.base.vo.BaseMenuTreeVO;
import com.stopboot.admin.base.vo.BaseVO;
import lombok.Data;

import java.util.List;

/**
 * @description:
 * @author: Lianyutao
 * @create: 2019/10/29 19:16
 * @version: 1.0.1
 **/

@Data
public class PermissionListVO extends BaseMenuTreeVO {

    private String component;

//    private String fullPath;

    private String title;

    private Boolean flag;

    private List<PermissionInfoVO> permissions;
}
