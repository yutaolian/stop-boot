package com.stopboot.admin.service.help.datasource;

import com.stopboot.admin.annotation.SbDataSource;
import com.stopboot.admin.dao.custom.mapper.help.StopBootTableMapper;
import com.stopboot.admin.db.DataSourceEnum;
import com.stopboot.admin.model.help.datasource.table.columns.TableColumnsParams;
import com.stopboot.admin.model.help.datasource.table.columns.TableColumnsVO;
import com.stopboot.admin.model.help.datasource.table.list.TableListVO;
import com.stopboot.admin.service.help.datasource.SbDataSourceServiceI;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description:
 * @author: Lianyutao
 * @create: 2019-10-16 14:39
 * @version:
 **/

@Slf4j
@Service
public class SbDataSourceServiceImpl implements SbDataSourceServiceI {

    @Resource
    private StopBootTableMapper stopBootTableMapper;

    @SbDataSource(DataSourceEnum.DB_MASTER)
    @Override
    public List<TableListVO> getTableList() {
        List<TableListVO> tableList = stopBootTableMapper.getTableList();
        return tableList;
    }

    @SbDataSource(DataSourceEnum.DB_MASTER)
    @Override
    public List<TableColumnsVO> getTableColumns(TableColumnsParams params) {
        List<TableColumnsVO> tableColumns = stopBootTableMapper.getTableColumns(params.getTableName());
        return tableColumns;
    }
}
