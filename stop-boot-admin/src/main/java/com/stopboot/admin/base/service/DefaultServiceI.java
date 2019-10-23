package com.stopboot.admin.base.service;

import com.stopboot.admin.base.params.*;
import com.stopboot.admin.common.PageResult;

/**
 * @description:
 * @author: Lianyutao
 * @create: 2019-09-19 11:18
 * @version:
 **/

public interface DefaultServiceI<PageVO, OneVO, PageParams extends BasePageParams,
        OneParams extends BaseParams,
        CreateParams extends BaseParams,
        UpdateParams extends BaseParams,
        DeleteParams extends BaseParams> {

    /**
     * 删除
     *
     * @param id
     * @return
     */
    default boolean delete(Integer id) {
        return false;
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    default boolean delete(DeleteParams id) {
        return false;
    }


    /**
     * 新增
     *
     * @param params
     * @return
     */
    default boolean add(CreateParams params) {
        return false;
    }

    /**
     * 查询单个
     *
     * @param id
     * @return
     */
    default OneVO one(Integer id) {
        return null;
    }

    /**
     * 查询单个
     *
     * @param params
     * @return
     */
    default OneVO one(OneParams params) {
        return null;
    }

    /**
     * 查询单个
     *
     * @param params
     * @return
     */
    default OneVO oneWithBLOBs(OneParams params) {
        return null;
    }

    /**
     * 更新
     *
     * @param params
     * @return
     */
    default boolean update(UpdateParams params) {
        return false;
    }

    /**
     * 更新
     *
     * @param params
     * @return
     */
    default boolean updateWithBLOBs(UpdateParams params) {
        return false;
    }

    /**
     * 分页
     *
     * @param params
     * @return
     */
    default PageResult<PageVO> page(PageParams params) {
        return null;
    }

}
