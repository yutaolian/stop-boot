package com.stopboot.admin.model.role.list;

import lombok.Data;

import java.io.Serializable;

/**
 * @description:
 * @author: Lianyutao
 * @create: 2019-09-23 15:25
 * @version:
 **/

@Data
public class RoleListVO implements Serializable {
    /**
     *
     */
    private Integer id;

    /**
     * 角色名称
     */
    private String name;

    /**
     * 描述
     */
    private String description;

    /**
     * 角色标签
     */
    private String tag;

    /**
     * 状态（1正常使用，0不使用）
     */
    private Integer status;
}
