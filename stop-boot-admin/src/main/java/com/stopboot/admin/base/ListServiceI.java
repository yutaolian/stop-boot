package com.stopboot.admin.base;


import java.util.List;

public interface ListServiceI<PageVO, ListVO, OneVO, PageParams,
        ListParams, OneParams, AddParams, UpdateParams>
        extends DefaultServiceI<PageVO, OneVO, PageParams, OneParams, AddParams, UpdateParams> {

    List<ListVO> list(ListParams params);

    List<ListVO> listWithBLOBs(ListParams params);

    /**
     *  以下含 Example 方法对外隐藏
     */
//    List<ListVO> listByExample(Example example);

//    List<ListVO> listByExampleWithBLOBs(Example example);

}
