package com.stopboot.admin.base.service;


import com.stopboot.admin.base.params.*;

import java.util.List;

/**
 * @description:
 * @author: Lianyutao
 * @create: 2019-09-19 11:18
 * @version:
 **/

public interface DefaultListServiceI<PageVO, ListVO, OneVO, PageParams extends BasePageParams,
        ListParams extends BaseParams, OneParams extends BaseParams, AddParams extends BaseParams, UpdateParams extends BaseParams, DeleteParams extends BaseParams>
        extends DefaultServiceI<PageVO, OneVO, PageParams, OneParams, AddParams, UpdateParams,DeleteParams> {

    /**
     * 根据params 获得列表
     * @param params
     * @return
     */
    default List<ListVO> list(ListParams params) {
        return null;
    }

    /**
     *
     * @param params
     * @return
     */
    default List<ListVO> listWithBLOBs(ListParams params){
        return null;
    }
}
