package com.stopboot.admin.model.system.dictionary.add;

import com.stopboot.admin.base.params.BaseAddParams;
import lombok.Data;

/**
 * @description:
 * @author: Lianyutao
 * @create: 2019/10/25 13:23
 * @version: 1.0.1
 **/

@Data
public class DictionaryAddParams extends BaseAddParams{
    /**
     *姓名
     *
     */
    private String name;
    /**
     *年龄
     *
     */
    private Object age;
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
    private Object status;
    /**
     *头像
     *
     */
    private String headImg;
    /**
     *删除标记（1正常，0删除）
     *
     */
    private Object deleteFlag;
    /**
     *更新时间
     *
     */
    private java.util.Date updateTime;
}
