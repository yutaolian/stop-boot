package com.stopboot.admin.model.test.page;

import com.stopboot.admin.base.params.BaseOneParams;
import lombok.Data;

/**
 * @description:
 * @author: Lianyutao
 * @create: 2019/10/24 22:03
 * @version: 1.0.1
 **/

@Data
public class Test1OneParams extends BaseOneParams{
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
