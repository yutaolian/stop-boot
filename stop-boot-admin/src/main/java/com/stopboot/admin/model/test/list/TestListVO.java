package com.stopboot.admin.model.test.list;

import com.alibaba.fastjson.annotation.JSONField;
import com.stopboot.admin.base.BaseVO;
import lombok.Data;

import java.util.Date;

/**
 * @description:
 * @author: Lianyutao
 * @create: 2019-09-27 11:31
 * @version:
 **/

@Data
public class TestListVO extends BaseVO {
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
