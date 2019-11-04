package com.stopboot.admin.model.system.dept.list;

import com.stopboot.admin.base.vo.BaseVO;
import lombok.Data;


/**
 * @description:  Dept service
 * @author: Lianyutao
 * @create: 2019/11/04 20:04
 * @version: 1.0.1
 **/

@Data
public class DeptListVO extends BaseVO {

    /**
    *
    *
    */
    private Integer id;
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
    /**
    *操作者id
    *
    */
    private Integer opUserId;
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



}
