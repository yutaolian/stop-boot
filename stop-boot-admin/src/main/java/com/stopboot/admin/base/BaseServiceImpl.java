package com.stopboot.admin.base;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.stopboot.admin.annotation.InvokeTime;
import com.stopboot.admin.annotation.SbDataSource;
import com.stopboot.admin.common.PageResult;
import com.stopboot.admin.db.DataSourceEnum;
import com.stopboot.admin.utils.SpringContextUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * @description:
 * @author: Lianyutao
 * @create: 2019-09-19 14:17
 * @version:
 **/

@Slf4j
public abstract class BaseServiceImpl<Mapper, Record, Example> implements BaseServiceI<Record, Example> {

    /**
     * 增
     *
     * @param record
     * @return
     */
    @SbDataSource(DataSourceEnum.DB_MASTER)
    @Override
    public int insert(Record record) {
        return (Integer) this.execute("insert", record);
    }

    @SbDataSource(DataSourceEnum.DB_MASTER)
    @Override
    public int insertSelective(Record record) {
        return (Integer) this.execute("insertSelective", record);
    }

    /**
     * 删
     *
     * @param example
     * @return
     */
    @SbDataSource(DataSourceEnum.DB_MASTER)
    @Override
    public int deleteByExample(Example example) {
        return (Integer) this.execute("deleteByExample", example);
    }

    @SbDataSource(DataSourceEnum.DB_MASTER)
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return (Integer) this.execute("deleteByPrimaryKey", id);
    }

    /**
     * 改
     *
     * @param record
     * @param example
     * @return
     */
    @SbDataSource(DataSourceEnum.DB_MASTER)
    @Override
    public int updateByExampleSelective(@Param("record") Record record, @Param("example") Example example) {
        return (Integer) this.execute("updateByExampleSelective", record, example);
    }

    @SbDataSource(DataSourceEnum.DB_MASTER)
    @Override
    public int updateByExample(@Param("record") Record record, @Param("example") Example example) {
        return (Integer) this.execute("updateByExample", record, example);
    }

    @SbDataSource(DataSourceEnum.DB_MASTER)
    @Override
    public int updateByPrimaryKeySelective(Record record) {
        return (Integer) this.execute("updateByPrimaryKeySelective", record);
    }

    @SbDataSource(DataSourceEnum.DB_MASTER)
    @Override
    public int updateByPrimaryKey(Record record) {
        return (Integer) this.execute("updateByPrimaryKey", record);
    }

    /**
     * 查
     *
     * @param id
     * @return
     */

    @SbDataSource(DataSourceEnum.DB_MASTER)
    @Override
    public Record selectByPrimaryKey(Integer id) {
        return (Record) this.execute("selectByPrimaryKey", id);
    }

    @SbDataSource(DataSourceEnum.DB_MASTER)
    @Override
    public List<Record> selectByExample(Example example) {
        return (List<Record>) this.execute("selectByExample", example);
    }

    @SbDataSource(DataSourceEnum.DB_MASTER)
    @Override
    public int countByExample(Example example) {
        return (Integer) this.execute("countByExample", example);
    }

    @SbDataSource(DataSourceEnum.DB_MASTER)
    @Override
    public PageResult<Record> pageByExample(Example example, Integer pageSize, Integer pageNum) {
        List<Record> list = (List<Record>) this.executePage("selectByExample", example, pageNum, pageSize);
        return new PageResult<>(new PageInfo<>(list));
    }

    @SbDataSource(DataSourceEnum.DB_MASTER)
    @Override
    public PageResult<Record> pageWithBLOBsByExample(Example example, Integer pageSize, Integer pageNum) {
        List<Record> list = (List<Record>) this.executePage("selectByExampleWithBLOBs", example, pageNum, pageSize);
        return new PageResult<>(new PageInfo<>(list));
    }


    public Object execute(String methodName, Object params) {
        try {
            Class<Mapper> mapperClass = (Class<Mapper>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
            Mapper mapper = SpringContextUtil.getBean(mapperClass);
            Method method = mapper.getClass().getDeclaredMethod(methodName, params.getClass());
            Object result = method.invoke(mapper, params);
            return result;
        } catch (Exception e) {
            log.error("BaseServiceImpl execute invoke error:{}",e.fillInStackTrace());
            return null;
        }
    }

    public Object execute(String methodName, Object record, Object example) {
        try {
            Class<Mapper> mapperClass = (Class<Mapper>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
            Mapper mapper = SpringContextUtil.getBean(mapperClass);
            Method method = mapper.getClass().getDeclaredMethod(methodName, record.getClass(), example.getClass());
            Object result = method.invoke(mapper, record, example);
            return result;
        } catch (Exception e) {
            log.error("BaseServiceImpl execute invoke error:{}",e.getMessage());
            return null;
        }
    }

    public Object executePage(String methodName, Object example, Integer pageNum, Integer pageSize) {
        try {
            Class<Mapper> mapperClass = (Class<Mapper>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
            Mapper mapper = SpringContextUtil.getBean(mapperClass);
            Method method = mapper.getClass().getDeclaredMethod(methodName, example.getClass());
            PageHelper.startPage(pageNum, pageSize);
            Object result = method.invoke(mapper, example);
            return result;
        } catch (Exception e) {
            log.error("BaseServiceImpl executePage invoke error:{}",e.getMessage());
            return null;
        }
    }
}
