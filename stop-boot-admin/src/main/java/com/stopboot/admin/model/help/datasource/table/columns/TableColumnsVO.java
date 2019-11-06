package com.stopboot.admin.model.help.datasource.table.columns;

import com.stopboot.admin.model.system.permission.list.PermissionInfoVO;
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
    private boolean pageShow = true;

    /**
     * 是否搜索显示
     */
    private boolean searchShow = true;

    /**
     * 是否创建显示
     */
    private boolean createShow = true;

    /**
     * 是否编辑显示
     */
    private boolean editShow = true;

    private String realType;

    /**
     * componentOptions: [{
     *                     value: 'Input',
     *                     label: 'Input 输入框'
     *                 }, {
     *                     value: 'Radio',
     *                     label: 'Radio 单选框'
     *                 }, {
     *                     value: 'Checkbox',
     *                     label: 'Checkbox 多选框'
     *                 }, {
     *                     value: 'Select',
     *                     label: 'Select 选择器'
     *                 }, {
     *                     value: 'Switch',
     *                     label: 'Switch 开关'
     *                 }, {
     *                     value: 'InputNumber',
     *                     label: 'InputNumber 计数器'
     *                 }, {
     *                     value: 'TimePicker',
     *                     label: 'TimePicker 时间选择器'
     *                 }, {
     *                     value: 'DatePicker',
     *                     label: 'DatePicker 日期选择器'
     *                 }, {
     *                     value: 'DateTimePicker',
     *                     label: 'DateTimePicker 日期时间选择器'
     *                 }],
     */
    private String componentName = "";

    private String dicKey = "";

    private String englishName = "";

    private String chineseName = "";


}
