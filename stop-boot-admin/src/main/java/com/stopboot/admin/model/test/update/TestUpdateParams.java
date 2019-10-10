package com.stopboot.admin.model.test.update;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @description:
 * @author: Lianyutao
 * @create: 2019-10-10 19:20
 * @version:
 **/

@Data
public class TestUpdateParams implements Serializable {

    @NotNull
    private Integer id;

    private String name;
}
