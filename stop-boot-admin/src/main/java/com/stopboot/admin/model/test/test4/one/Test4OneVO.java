package com.stopboot.admin.model.test.test4.one;

import com.stopboot.admin.base.vo.BaseVO;
import lombok.Data;


/**
 * @description:  Test4 service
 * @author: Lianyutao
 * @create: 2019/11/07 18:48
 * @version: 1.0.1
 **/

@Data
public class Test4OneVO extends BaseVO {

    /**
    *id
    *
    */
    private Integer id;
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
