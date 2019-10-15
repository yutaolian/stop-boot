package com.stopboot.admin.base;

import com.stopboot.admin.common.PageResult;


public interface DefaultServiceI<PageVO, OneVO, PageParams, OneParams , AddParams, UpdateParams>  {

    boolean delete(Integer id);

    boolean add(AddParams params);

    OneVO one(Integer id);

    OneVO one(OneParams params);

    OneVO oneWithBLOBs(OneParams params);

    boolean update(UpdateParams params);

    boolean updateWithBLOBs(UpdateParams params);

    PageResult<PageVO> page(PageParams params);

    /**
     *  以下含 Example 方法对外隐藏
     */
//    OneVO oneByExample(Example example);

//    OneVO oneByExampleWithBLOBs(Example example);

//    boolean updateByExampleWithBLOBs(UpdateParams params, Example example);

//    boolean updateByExample(UpdateParams params, Example example);

//    PageResult<PageVO> pageByExample(PageParams params, Example example);
}
