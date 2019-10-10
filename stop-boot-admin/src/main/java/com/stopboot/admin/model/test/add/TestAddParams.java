package com.stopboot.admin.model.test.add;

import lombok.Data;

import java.io.Serializable;

/**
 * @description:
 * @author: Lianyutao
 * @create: 2019-10-10 19:36
 * @version:
 **/

@Data
public class TestAddParams implements Serializable {
    /**
     *
     */
    private Integer id;

    /**
     * 姓名
     */
    private String name;
}
