package com.stopboot.admin.model.help.generator.dowm;/**
 * @version:0.0.1
 * @author: Lianyutao
 * @create: 2019-10-17 13:58
 * @description:
 **/

import com.stopboot.admin.base.params.BaseParams;
import lombok.Data;

import java.util.List;

/**
 * @version:0.0.1
 *
 * @author: Lianyutao
 *
 * @create: 2019-10-17 13:58

 * @description:
 **/

@Data
public class GeneratorParams extends BaseParams {

    /**
     * 菜单ID
     */
    private Integer menuId;


    /**
     * 当前节点全路径
     */
    private String fullPath;

    /**
     * 表名
     */
    private String tableName;

    /**
     * 0 全部，1 java 后端 2 java android 3.js 5 iOS oc 6 iOS swift 7
     */
    private Integer langType;

    /**
     * 字段信息
     */
    private List<ColumInfo> columsInfoList;


}
