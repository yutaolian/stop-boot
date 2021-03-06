package com.stopboot.admin.model.test.test3.list;

import com.stopboot.admin.base.params.BaseListParams;
import lombok.Data;

/**
 * @description:
 * @author: Lianyutao
 * @create: 2019/11/06 20:56
 * @version: 1.0.1
 **/

@Data
public class Test3ListParams extends BaseListParams{
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
