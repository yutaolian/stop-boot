package com.stopboot.admin.base;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @description:
 * @author: Lianyutao
 * @create: 2019-10-15 14:52
 * @version:
 **/

@Data
public class BaseParams implements Serializable {
    @NotNull
    @Max(Integer.MAX_VALUE)
    private Integer id;
}
