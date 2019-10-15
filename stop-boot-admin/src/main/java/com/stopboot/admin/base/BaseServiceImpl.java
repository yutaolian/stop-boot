package com.stopboot.admin.base;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.stopboot.admin.annotation.InvokeTime;
import com.stopboot.admin.annotation.SbDataSource;
import com.stopboot.admin.common.PageResult;
import com.stopboot.admin.db.DataSourceEnum;
import com.stopboot.admin.utils.ClassUtil;
import com.stopboot.admin.utils.SpringContextUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;

import java.lang.reflect.Method;
import java.util.List;

/**
 * @description: 事务需要加到对应实现类的方法上，否则不起作用
 * @author: Lianyutao
 * @create: 2019-09-19 14:17
 * @version:
 **/

@Slf4j
public abstract class BaseServiceImpl<Mapper, Record, Example> implements BaseServiceI<Record, Example> {


    private static final int Mapper_INDEX = 0;
    private static final int Record_INDEX = 1;
    private static final int Example_INDEX = 2;
    /**
     * 数量
     *
     * @param example
     * @return
     */
    @SbDataSource(DataSourceEnum.DB_MASTER)
    @Override
    public int countByExample(Example example) {
        return (Integer) this.execute("countByExample", example);
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
     * 查
     *
     * @param id
     * @return
     */

    @InvokeTime()
    @SbDataSource(DataSourceEnum.DB_MASTER)
    @Override
    public Record selectByPrimaryKey(Integer id) {
        return (Record) this.execute("selectByPrimaryKey", id);
    }

    @InvokeTime()
    @SbDataSource(DataSourceEnum.DB_MASTER)
    @Override
    public List<Record> selectByExampleWithBLOBs(Example example) {
        return (List<Record>) this.execute("selectByExampleWithBLOBs", example);
    }

    @InvokeTime()
    @SbDataSource(DataSourceEnum.DB_MASTER)
    @Override
    public List<Record> selectByExample(Example example) {
        return (List<Record>) this.execute("selectByExample", example);
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
    public int updateByExampleWithBLOBs(Record record, Example example) {
        return (Integer) this.execute("updateByExampleWithBLOBs", record, example);
    }

    @SbDataSource(DataSourceEnum.DB_MASTER)
    @Override
    public int updateByPrimaryKeyWithBLOBs(Record record) {
        return (Integer) this.execute("updateByPrimaryKeyWithBLOBs", record);
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
     * 自定义方法
     *
     * @param example
     * @param pageNum
     * @param pageSize
     * @return
     */
    @SbDataSource(DataSourceEnum.DB_MASTER)
    @Override
    public PageResult<Record> pageByExample(Example example, Integer pageNum, Integer pageSize) {
        List<Record> list = (List<Record>) this.executePage("selectByExample", example, pageNum, pageSize);
        return new PageResult<>(new PageInfo<>(list));
    }

    @SbDataSource(DataSourceEnum.DB_MASTER)
    @Override
    public PageResult<Record> pageWithBLOBsByExample(Example example, Integer pageNum, Integer pageSize) {
        List<Record> list = (List<Record>) this.executePage("selectByExampleWithBLOBs", example, pageNum, pageSize);
        return new PageResult<>(new PageInfo<>(list));
    }


    public Object execute(String methodName, Object params) {
        try {
            Mapper mapper = this.mapper();
            Method method = mapper.getClass().getDeclaredMethod(methodName, params.getClass());
            return method.invoke(mapper, params);
        } catch (Exception e) {
            log.error("BaseServiceImpl execute invoke error:{}", e.fillInStackTrace());
            return null;
        }
    }

    public Object execute(String methodName, Object record, Object example) {
        try {
            Mapper mapper = this.mapper();
            if (example == null) {
                Class<Example> exampleClass = (Class<Example>) ClassUtil.getClass(getClass(), Example_INDEX);
                example = exampleClass.newInstance();
            }
            Method method = mapper.getClass().getDeclaredMethod(methodName, record.getClass(), example.getClass());
            return method.invoke(mapper, record, example);
        } catch (Exception e) {
            log.error("BaseServiceImpl execute invoke error:{}", e.getMessage());
            return null;
        }
    }

    public Object executePage(String methodName, Object example, Integer pageNum, Integer pageSize) {
        try {
            Mapper mapper = this.mapper();
            if (example == null) {
                Class<Example> exampleClass = (Class<Example>) ClassUtil.getClass(getClass(), Example_INDEX);
                example = exampleClass.newInstance();
            }
            Method method = mapper.getClass().getDeclaredMethod(methodName, example.getClass());
            PageHelper.startPage(pageNum, pageSize);
            return method.invoke(mapper, example);
        } catch (Exception e) {
            log.error("BaseServiceImpl executePage invoke error:{}", e.getMessage());
            return null;
        }
    }

    private Mapper mapper() {
        Class<Mapper> mapperClass = (Class<Mapper>) ClassUtil.getClass(getClass(), Mapper_INDEX);
        Mapper mapper = SpringContextUtil.getBean(mapperClass);
        return mapper;
    }
}
