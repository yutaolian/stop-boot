package com.stopboot.admin.dao.custom.mapper.help;

import com.stopboot.admin.model.help.datasource.table.columns.TableColumnsVO;
import com.stopboot.admin.model.help.datasource.table.list.TableListVO;

import java.util.List;


public interface StopBootTableMapper {


    /**
     *
     * @return
     */
    List<TableListVO> getTableList();

    /**
     *
     * @param tableName
     * @return
     */
    List<TableColumnsVO> getTableColumns(String tableName);



}
