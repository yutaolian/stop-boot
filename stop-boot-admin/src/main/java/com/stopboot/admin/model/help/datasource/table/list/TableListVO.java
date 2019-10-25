package com.stopboot.admin.model.help.datasource.table.list;

import cn.hutool.core.util.StrUtil;
import lombok.Data;

import java.io.Serializable;

/**
 * @description:
 * @author: Lianyutao
 * @create: 2019-10-16 14:28
 * @version:
 **/

@Data
public class TableListVO implements Serializable {

    private String tableName;
    private String tableSchema;
    private String engine;
    private String tableCollation;
    private String tableComment;

}
