package com.stopboot.admin.model.test.test2.test22.update;

import com.stopboot.admin.base.params.BaseUpdateParams;
import lombok.Data;

/**
 * @description:
 * @author: Lianyutao
 * @create: 2019/11/01 17:09
 * @version: 1.0.1
 **/

@Data
public class Test22UpdateParams extends BaseUpdateParams{
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
