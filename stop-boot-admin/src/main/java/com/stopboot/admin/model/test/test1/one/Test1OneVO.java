package com.stopboot.admin.model.test.test1.one;

import com.stopboot.admin.base.vo.BaseVO;
import lombok.Data;


/**
 * @description:  Test1 service
 * @author: Lianyutao
 * @create: 2019/10/25 10:03
 * @version: 1.0.1
 **/

@Data
public class Test1OneVO extends BaseVO {

    /**
    *
    *
    */
    private String id;
    /**
    *姓名
    *
    */
    private String name;
    /**
    *年龄
    *
    */
    private String age;
    /**
    *生日
    *
    */
    private String birthday;
    /**
    *创建时间
    *
    */
    private String createTime;
    /**
    *信息
    *
    */
    private String info;
    /**
    *状态
    *
    */
    private String status;
    /**
    *头像
    *
    */
    private String headImg;
    /**
    *删除标记（1正常，0删除）
    *
    */
    private String deleteFlag;
    /**
    *更新时间
    *
    */
    private String updateTime;



}
