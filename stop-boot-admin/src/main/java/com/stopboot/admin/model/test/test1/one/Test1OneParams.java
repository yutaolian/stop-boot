package com.stopboot.admin.model.test.test1.one;

import com.stopboot.admin.base.params.BaseOneParams;
import lombok.Data;

/**
 * @description:
 * @author: Lianyutao
 * @create: 2019/10/30 12:17
 * @version: 1.0.1
 **/

@Data
public class Test1OneParams extends BaseOneParams{
    /**
     *姓名
     *
     */
    private String name;
    /**
     *年龄
     *
     */
    private Integer age;
    /**
     *生日
     *
     */
    private java.util.Date birthday;
    /**
     *创建时间
     *
     */
    private java.util.Date createTime;
    /**
     *信息
     *
     */
    private String info;
    /**
     *状态
     *
     */
    private Integer status;
    /**
     *头像
     *
     */
    private String headImg;
    /**
     *删除标记（1正常，0删除）
     *
     */
    private Integer deleteFlag;
    /**
     *更新时间
     *
     */
    private java.util.Date updateTime;
}
