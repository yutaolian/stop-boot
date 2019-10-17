package com.stopboot.admin.base.params;


import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.io.Serializable;

/**
 * @description:
 * @author: Lianyutao
 * @create: 2019-10-15 14:52
 * @version:
 **/
@Data
public class BaseParams implements Serializable {

    @Min(1)
    @Max(Integer.MAX_VALUE)
    private Integer id;

}
