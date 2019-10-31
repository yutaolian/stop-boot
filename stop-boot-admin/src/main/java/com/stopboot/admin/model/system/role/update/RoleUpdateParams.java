package com.stopboot.admin.model.system.role.update;

import com.stopboot.admin.base.params.BaseUpdateParams;
import lombok.Data;

/**
 * @description:
 * @author: Lianyutao
 * @create: 2019/10/30 14:06
 * @version: 1.0.1
 **/

@Data
public class RoleUpdateParams extends BaseUpdateParams{
    /**
     *角色名称
     *
     */
    private String name;
    /**
     *描述
     *
     */
    private String description;
    /**
     *角色标签
     *
     */
    private String tag;
    /**
     *状态（1正常使用，0不使用）
     *
     */
    private Integer status;
    /**
     *创建时间
     *
     */
    private java.util.Date createTime;
    /**
     *更新时间
     *
     */
    private java.util.Date updateTime;
    /**
     *删除标识（0删除，1未删除）
     *
     */
    private Integer deleteFlag;
}
