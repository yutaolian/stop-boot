package com.stopboot.admin.base.service;

import com.stopboot.admin.base.params.*;
import com.stopboot.admin.common.PageResult;
import com.stopboot.admin.utils.BeansHelper;
import com.stopboot.admin.utils.ClassUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: Lianyutao
 * @create: 2019-10-15 10:04
 * @version:
 **/
@Service
public class DefaultServiceImpl<DBMapper, DBRecord, DBExample, PageVO, ListVO, OneVO, PageParams extends BasePageParams,
        ListParams extends BaseParams, OneParams extends BaseParams, AddParams extends BaseParams, UpdateParams extends BaseParams, DeleteParams extends BaseParams>
        extends BaseServiceImpl<DBMapper, DBRecord, DBExample>
        implements DefaultServiceI<PageVO, ListVO, OneVO, PageParams, ListParams, OneParams, AddParams, UpdateParams, DeleteParams> {

    private static final int DBRECORD_INDEX = 1;
    private static final int PAGEVO_INDEX = 3;
    private static final int LIST_VO_INDEX = 4;
    private static final int ONEVO_INDEX = 5;

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
        return new ArrayList<>();
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
        return new ArrayList<>();
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


    /**
     * 删除
     *
     * @param id
     * @return
     */
    @Override
    public boolean delete(Integer id) {
        return this.deleteByPrimaryKey(id) > 0 ? true : false;
    }

    @Override
    public boolean delete(DeleteParams deleteParams) {
        return this.deleteByPrimaryKey(deleteParams.getId()) > 0 ? true : false;
    }

    /**
     * 新增
     *
     * @param params
     * @return
     */
    @Override
    public boolean add(AddParams params) {
        DBRecord record = (DBRecord) BeansHelper.getInstance().convert(params, getClass(DBRECORD_INDEX));
        return this.insertSelective(record) > 0 ? true : false;
    }

    /**
     * 详情
     *
     * @param id
     * @return
     */
    @Override
    public OneVO one(Integer id) {
        DBRecord record = this.selectByPrimaryKey(id);
        OneVO one = (OneVO) BeansHelper.getInstance().convert(record, getClass(ONEVO_INDEX));
        return one;
    }

    /**
     * 直接获取数据库数据
     *
     * @param id
     * @return
     */
    public DBRecord oneFromDB(Integer id) {
        DBRecord record = this.selectByPrimaryKey(id);
        return record;
    }

    /**
     * 详情
     * <p>
     * 多条件查询需要子类自己实现
     *
     * @param params
     * @return
     */
    @Override
    public OneVO one(OneParams params) {
        return this.one(params.getId());
    }

    /**
     * 详情
     * 多条件查询需要子类重写
     *
     * @param params
     * @return
     */
    @Override
    public OneVO oneWithBLOBs(OneParams params) {
        return this.one(params.getId());
    }

    /**
     * 更新
     *
     * @param params
     * @return
     */
    @Override
    public boolean update(UpdateParams params) {
        DBRecord record = (DBRecord) BeansHelper.getInstance().convert(params, getClass(DBRECORD_INDEX));
        return this.updateByPrimaryKeySelective(record) > 0 ? true : false;
    }

    /**
     * 更新
     *
     * @param params
     * @return
     */
    @Override
    public boolean updateWithBLOBs(UpdateParams params) {
        DBRecord record = (DBRecord) BeansHelper.getInstance().convert(params, getClass(DBRECORD_INDEX));
        return this.updateByPrimaryKeyWithBLOBs(record) > 0 ? true : false;
    }

    /**
     * 分页
     * 多条件查询需要子类重写
     *
     * @param pageParams
     * @return
     */
    @Override
    public PageResult<PageVO> page(PageParams pageParams) {
        return this.pageByExample(pageParams, null);
    }

    /**
     * 多条件查询
     * Example 方法对具体实现类隐藏
     *
     * @param example
     * @return
     */
    public OneVO oneByExample(DBExample example) {
        List<DBRecord> records = this.selectByExample(example);
        return getOneVO((List<DBRecord>) records);
    }


    /**
     * 多条件查询
     * Example 方法对具体实现类隐藏
     *
     * @param example
     * @return
     */
    public OneVO oneByExampleWithBLOBs(DBExample example) {
        List<DBRecord> records = this.selectByExampleWithBLOBs(example);
        return getOneVO((List<DBRecord>) records);
    }

    /**
     * 多条件更新
     * Example 方法对具体实现类隐藏
     *
     * @param example
     * @return
     */
    public boolean updateByExample(UpdateParams params, DBExample example) {
        DBRecord record = (DBRecord) BeansHelper.getInstance().convert(params, getClass(DBRECORD_INDEX));
        return this.updateByExampleSelective(record, example) > 0 ? true : false;
    }

    /**
     * 多条件更新
     * Example 方法对具体实现类隐藏
     *
     * @param example
     * @return
     */
    public boolean updateByExampleWithBLOBs(UpdateParams params, DBExample example) {
        DBRecord record = (DBRecord) BeansHelper.getInstance().convert(params, getClass(DBRECORD_INDEX));
        return this.updateByExampleWithBLOBs(record, example) > 0 ? true : false;
    }

    /**
     * 多条件分页
     * Example 方法对具体实现类隐藏
     *
     * @param example
     * @return
     */
    public PageResult<PageVO> pageByExample(PageParams params, DBExample example) {
        PageResult<DBRecord> pageResult = this.pageByExample(example, params.getPageNum(), params.getPageSize());
        PageResult<PageVO> pageVOResult = BeansHelper.getInstance().convert(pageResult, getClass(PAGEVO_INDEX));
        return pageVOResult;
    }

    private OneVO getOneVO(List<DBRecord> records) {
        DBRecord record = records != null && records.size() > 0 ? records.get(0) : null;
        if (record != null) {
            OneVO one = (OneVO) BeansHelper.getInstance().convert(record, getClass(ONEVO_INDEX));
            return one;
        } else {
            return null;
        }
    }


}
