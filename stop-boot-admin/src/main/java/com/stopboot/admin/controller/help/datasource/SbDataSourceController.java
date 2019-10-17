package com.stopboot.admin.controller.help.datasource;

import com.stopboot.admin.common.ResultData;
import com.stopboot.admin.model.help.datasource.table.columns.TableColumnsParams;
import com.stopboot.admin.model.help.datasource.table.columns.TableColumnsVO;
import com.stopboot.admin.model.help.datasource.table.list.TableListVO;
import com.stopboot.admin.service.help.datasource.SbDataSourceServiceI;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description:
 * @author: Lianyutao
 * @create: 2019-10-16 10:26
 * @version:
 **/

@Slf4j
@RestController
@RequestMapping("help/dataSource")
public class SbDataSourceController {

    @Resource
    private SbDataSourceServiceI generatorService;


    /**
     * 获得数据库的全部表名
     *
     * @return
     */
    @PostMapping("table/list")
    public ResultData<TableListVO> tableList() {
        ResultData resultData = ResultData.build();
        List<TableListVO> list = generatorService.getTableList();
        if (!ObjectUtils.isEmpty(list)) {
            resultData.success().setData(list);
        } else {
            resultData.empty();
        }
        return resultData;
    }


    /**
     * 根据表名获得表的全部字段
     *
     * @param params
     * @return
     */
    @PostMapping("table/columns")
    public ResultData<TableColumnsVO> tableColumns(@RequestBody TableColumnsParams params) {
        ResultData resultData = ResultData.build();
        List<TableColumnsVO> list = generatorService.getTableColumns(params);
        if (!ObjectUtils.isEmpty(list)) {
            resultData.success().setData(list);
        } else {
            resultData.empty();
        }
        return resultData;
    }


}
