package com.stopboot.admin.model.test.page;

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
    private Byte age;

    /**
     * 生日
     */
    private Date birthday;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 状态
     */
    private Byte status;

    /**
     * 存款
     */
    private BigDecimal money;

    /**
     * 信息
     */
    private String info;

}
