package com.stopboot.admin.model.menu.list;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @description:
 * @author: Lianyutao
 * @create: 2019-09-11 11:52
 * @version:
 **/

@Data
public class MenuListVOParams implements Serializable {

    @NotNull
    @Max(Integer.MAX_VALUE)
    private Integer userId;
}
