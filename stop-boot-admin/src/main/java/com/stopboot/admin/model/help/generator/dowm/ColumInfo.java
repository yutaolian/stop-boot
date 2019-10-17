package com.stopboot.admin.model.help.generator.dowm;/**
 * @version:0.0.1
 * @author: Lianyutao
 * @create: 2019-10-17 14:01
 * @description:
 **/

import lombok.Data;

import java.io.Serializable;

/**
 * @version:0.0.1
 *
 * @author: Lianyutao
 *
 * @create: 2019-10-17 14:01

 * @description:
 **/

@Data
public class ColumInfo implements Serializable {

    //标题
    private String title;

    private String columnName;
    private String dataType;
    private String nullable;
    private String columnComment;
}
