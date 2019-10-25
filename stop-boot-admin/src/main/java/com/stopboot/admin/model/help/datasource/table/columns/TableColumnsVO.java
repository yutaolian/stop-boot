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
    private String columnKey;
    private String camelColumnName;

    /**
     * 是否分页列表显示
     */
    private boolean pageShow;

    /**
     *  是否搜索显示
     */
    private boolean searchShow;

    /**
     * 是否创建显示
     */
    private boolean createShow;

    /**
     * 是否编辑显示
     */
    private boolean editShow;

    private String realType;

}
