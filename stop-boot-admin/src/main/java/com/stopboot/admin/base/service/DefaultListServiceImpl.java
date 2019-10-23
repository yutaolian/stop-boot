package com.stopboot.admin.base.service;

import com.stopboot.admin.base.params.*;
import com.stopboot.admin.utils.BeansHelper;
import com.stopboot.admin.utils.ClassUtil;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: Lianyutao
 * @create: 2019-10-15 10:04
 * @version:
 **/
@Service
public class DefaultListServiceImpl<DBMapper, DBRecord, DBExample, PageVO, ListVO, OneVO, PageParams extends BasePageParams,
        ListParams extends BaseParams, OneParams extends BaseParams, AddParams extends BaseParams, UpdateParams extends BaseParams, DeleteParams extends BaseParams>
        extends DefaultServiceImpl<DBMapper, DBRecord, DBExample, PageVO, OneVO, PageParams, OneParams, AddParams, UpdateParams,DeleteParams>
        implements DefaultListServiceI<PageVO, ListVO, OneVO, PageParams, ListParams, OneParams, AddParams, UpdateParams,DeleteParams> {

    private static final int LIST_VO_INDEX = 4;

    private Class<?> getClass(Integer index) {
        return ClassUtil.getClass(getClass(), index);
    }

    /**
     * 列表
     * 多条件查询需要子类重写
     *
     * @param params
     * @return
     */
    @Override
    public List<ListVO> list(ListParams params) {
        return null;
    }

    /**
     * 列表
     * 多条件查询需要子类重写
     *
     * @param params
     * @return
     */
    @Override
    public List<ListVO> listWithBLOBs(ListParams params) {
        return null;
    }


    /**
     * 多条件查询 list
     * 含 Example 方法对外隐藏
     *
     * @param example
     * @return
     */
    public List<ListVO> listByExample(DBExample example) {
        List<DBRecord> records = this.selectByExample(example);
        List<ListVO> listVOS = (List<ListVO>) BeansHelper.getInstance().convert(records, getClass(LIST_VO_INDEX));
        return listVOS;
    }

    /**
     * 多条件查询 list
     *
     * @param example
     * @return
     */
    public List<ListVO> listByExampleWithBLOBs(DBExample example) {
        List<DBRecord> records = this.selectByExampleWithBLOBs(example);
        List<ListVO> listVOS = (List<ListVO>) BeansHelper.getInstance().convert(records, getClass(LIST_VO_INDEX));
        return listVOS;
    }


}
