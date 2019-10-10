package com.stopboot.admin.base;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @description:
 * @author: Lianyutao
 * @create: 2019-09-27 11:37
 * @version:
 **/

@Data
public class BasePageParams implements Serializable {

    @NotNull
    @Max(Integer.MAX_VALUE)
    private Integer pageNum;

    /**
     * 分页数据不能超过200条
     */
    @NotNull
    @Max(200)
    private Integer pageSize;
}
