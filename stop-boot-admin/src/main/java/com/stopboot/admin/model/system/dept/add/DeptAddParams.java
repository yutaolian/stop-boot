package com.stopboot.admin.model.system.dept.add;

import com.stopboot.admin.base.params.BaseAddParams;
import lombok.Data;

/**
 * @description:
 * @author: Lianyutao
 * @create: 2019/10/25 12:16
 * @version: 1.0.1
 **/

@Data
public class DeptAddParams extends BaseAddParams{
    /**
     *创建时间
     *
     */
    private String createTime;
    /**
     *更新时间
     *
     */
    private String updateTime;
    /**
     *操作者id
     *
     */
    private String opUserId;
    /**
     *状态（1正常使用，0不使用）
     *
     */
    private String status;
    /**
     *删除标识（0删除，1未删除）
     *
     */
    private String deleteFlag;
}
