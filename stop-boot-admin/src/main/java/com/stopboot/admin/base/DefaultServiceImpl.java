package com.stopboot.admin.base;

import com.stopboot.admin.common.PageResult;
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
public abstract class DefaultServiceImpl<Mapper, Record, Example, PageVO, OneVO, PageParams extends BasePageParams, OneParams extends BaseParams, AddParams extends BaseParams, UpdateParams extends BaseParams>
        extends BaseServiceImpl<Mapper, Record, Example> implements DefaultServiceI<PageVO, OneVO, PageParams, OneParams , AddParams, UpdateParams> {

    private static final int Mapper_INDEX = 0;
    private static final int Record_INDEX = 1;
    private static final int Example_INDEX = 2;
    private static final int PageVO_INDEX = 3;
    private static final int OneVO_INDEX = 4;
    private static final int PageParams_INDEX = 5;
    private static final int OneParams_INDEX = 6;
    private static final int AddParams_INDEX = 7;
    private static final int UpdateParams_INDEX = 8;

    private Class<?> getClass(Integer index) {
        return ClassUtil.getClass(getClass(), index);
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

    /**
     * 新增
     *
     * @param params
     * @return
     */
    @Override
    public boolean add(AddParams params) {
        Record record = (Record) BeansHelper.getInstance().convert(params, getClass(AddParams_INDEX));
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
        Record record = this.selectByPrimaryKey(id);
        OneVO one = (OneVO) BeansHelper.getInstance().convert(record, getClass(OneVO_INDEX));
        return one;
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
        Record record = (Record) BeansHelper.getInstance().convert(params, getClass(Record_INDEX));
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
        Record record = (Record) BeansHelper.getInstance().convert(params, getClass(Record_INDEX));
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
     *
     * @param example
     * @return
     */
    public OneVO oneByExample(Example example) {
        List<Record> records = this.selectByExample(example);
        Record record = records != null && records.size() > 0 ? records.get(0) : null;
        if (record != null) {
            OneVO one = (OneVO) BeansHelper.getInstance().convert(record, getClass(OneVO_INDEX));
            return one;
        } else {
            return null;
        }
    }

    /**
     * 多条件查询
     *
     * @param example
     * @return
     */
    public OneVO oneByExampleWithBLOBs(Example example) {
        List<Record> records = this.selectByExampleWithBLOBs(example);
        Record record = records != null && records.size() > 0 ? records.get(0) : null;
        if (record != null) {
            OneVO one = (OneVO) BeansHelper.getInstance().convert(record, getClass(OneVO_INDEX));
            return one;
        } else {
            return null;
        }
    }

    /**
     * 多条件更新
     *
     * @param example
     * @return
     */
    public boolean updateByExample(UpdateParams params, Example example) {
        Record record = (Record) BeansHelper.getInstance().convert(params, getClass(Record_INDEX));
        return this.updateByExampleSelective(record, example) > 0 ? true : false;
    }

    /**
     * 多条件更新
     *
     * @param example
     * @return
     */
    public boolean updateByExampleWithBLOBs(UpdateParams params, Example example) {
        Record record = (Record) BeansHelper.getInstance().convert(params, getClass(Record_INDEX));
        return this.updateByExampleWithBLOBs(record, example) > 0 ? true : false;
    }

    /**
     * 多条件分页
     *
     * @param example
     * @return
     */
    public PageResult<PageVO> pageByExample(PageParams params, Example example) {
        PageResult<Record> pageResult = this.pageByExample(example, params.getPageNum(), params.getPageSize());
        PageResult<PageVO> pageVOResult = BeansHelper.getInstance().convert(pageResult, getClass(PageVO_INDEX));
        return pageVOResult;
    }
}
