package com.stopboot.admin.model.system.admin.page;

import com.stopboot.admin.base.params.BasePageParams;
import lombok.Data;

/**
 * @description:
 * @author: Lianyutao
 * @create: 2019/10/31 16:45
 * @version: 1.0.1
 **/

@Data
public class AdminPageParams extends BasePageParams{
    /**
     *姓名
     *
     */
    private String name;
    /**
     *手机号
     *
     */
    private String mobile;
    /**
     *密码
     *
     */
    private String password;
    /**
     *邮箱
     *
     */
    private String email;
    /**
     *状态（1正常使用，0不使用）
     *
     */
    private Integer status;
    /**
     *删除标识（0删除，1未删除）
     *
     */
    private Integer deleteFlag;
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
}
