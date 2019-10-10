package com.stopboot.admin.model.test.detail;

import lombok.Data;
import org.springframework.context.annotation.Scope;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @description:
 * @author: Lianyutao
 * @create: 2019-10-09 10:29
 * @version:
 **/

@Data
public class TestOneVO implements Serializable {
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
