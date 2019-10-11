package com.stopboot.admin.model.test.page;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @description:
 * @author: Lianyutao
 * @create: 2019-09-27 11:31
 * @version:
 **/

@Data
public class TestPageVO implements Serializable {
    /**
     *
     */
    private Integer id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 生日
     */
    @JSONField(format = "yyyy-MM-dd")
    private Date birthday;

    /**
     * 创建时间
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 头像
     */
    private String headImg;

    /**
     * 删除标记（1正常，0删除）
     */
    private Integer deleteFlag;

    /**
     * 信息
     */
    private String info;


}
