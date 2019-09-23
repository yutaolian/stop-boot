package com.stopboot.admin.model.role.page;

import lombok.Data;

import java.io.Serializable;

/**
 * @description: 角色列表
 * @author: Lianyutao
 * @create: 2019-09-23 15:27
 * @version:
 **/

@Data
public class RolePageVOParams implements Serializable {

    private Integer pageNum;

    private Integer pageSize;

}
