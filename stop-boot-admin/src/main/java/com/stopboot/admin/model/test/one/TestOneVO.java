package com.stopboot.admin.model.test.one;

import com.stopboot.admin.base.vo.BaseVO;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @description:
 * @author: Lianyutao
 * @create: 2019-10-09 10:29
 * @version:
 **/

@Data
public class TestOneVO extends BaseVO {
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
