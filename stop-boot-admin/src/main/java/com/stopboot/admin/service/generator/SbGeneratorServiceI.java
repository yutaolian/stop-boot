package com.stopboot.admin.service.generator;

import com.stopboot.admin.model.help.datasource.table.columns.TableColumnsParams;
import com.stopboot.admin.model.help.datasource.table.columns.TableColumnsVO;
import com.stopboot.admin.model.help.datasource.table.list.TableListVO;
import com.stopboot.admin.model.help.generator.dowm.GeneratorParams;
import com.stopboot.admin.model.help.generator.dowm.GeneratorVO;
import com.stopboot.admin.model.help.generator.pre.GeneratorPreParams;
import com.stopboot.admin.model.help.generator.pre.GeneratorPreVO;

import java.util.List;

public interface SbGeneratorServiceI {

    /**
     * 生成代码前加载基本信息
     * @return
     * @param params
     */
    GeneratorPreVO pre(GeneratorPreParams params);


    GeneratorVO done(GeneratorParams params);

    List<TableListVO> getTableList();

    List<TableColumnsVO> getTableColumns(TableColumnsParams params);
}
