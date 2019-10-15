package com.stopboot.admin.base;

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
public abstract class ListServiceImpl<Mapper, Record, Example, PageVO, ListVO, OneVO, PageParams extends BasePageParams,
        ListParams extends BaseParams, OneParams extends BaseParams, AddParams extends BaseParams, UpdateParams extends BaseParams>
        extends DefaultServiceImpl<Mapper, Record, Example, PageVO, OneVO, PageParams, OneParams, AddParams, UpdateParams>
        implements ListServiceI<PageVO, ListVO, OneVO, PageParams, ListParams, OneParams, AddParams, UpdateParams> {

    private static final int Mapper_INDEX = 0;
    private static final int Record_INDEX = 1;
    private static final int Example_INDEX = 2;
    private static final int PageVO_INDEX = 3;
    private static final int ListVO_INDEX = 4;
    private static final int OneVO_INDEX = 5;
    private static final int PageParams_INDEX = 6;
    private static final int ListParams_INDEX = 7;
    private static final int OneParams_INDEX = 8;
    private static final int AddParams_INDEX = 9;
    private static final int UpdateParams_INDEX = 10;

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
    public List<ListVO> listWithBLOBs(ListParams params) {
        return null;
    }

    /**
     * 多条件查询 list
     *
     * @param example
     * @return
     */
    public List<ListVO> listByExample(Example example) {
        List<Record> records = this.selectByExample(example);
        List<ListVO> listVOS = (List<ListVO>) BeansHelper.getInstance().convert(records, getClass(ListVO_INDEX));
        return listVOS;
    }

    /**
     * 多条件查询 list
     *
     * @param example
     * @return
     */
    public List<ListVO> listByExampleWithBLOBs(Example example) {
        List<Record> records = this.selectByExampleWithBLOBs(example);
        List<ListVO> listVOS = (List<ListVO>) BeansHelper.getInstance().convert(records, getClass(ListVO_INDEX));
        return listVOS;
    }


}
