package com.stopboot.admin.model.help.datasource.table.columns;

import lombok.Data;

import java.io.Serializable;

/**
 * @description:
 * @author: Lianyutao
 * @create: 2019-10-16 15:34
 * @version:
 **/

@Data
public class TableColumnsVO implements Serializable {
    private String ordinalPosition;
    private String columnName;
    private String dataType;
    private String nullable;
    private String columnComment;
}
