package com.stopboot.admin.base;

import com.stopboot.admin.annotation.InvokeTime;
import com.stopboot.admin.annotation.SbDataSource;
import com.stopboot.admin.db.DataSourceEnum;
import com.stopboot.admin.utils.SpringContextUtil;
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

public abstract class BaseServiceImpl<Mapper, Record, Example> implements BaseServiceI<Record, Example> {

    @SbDataSource(DataSourceEnum.DB_SLAVE)
    @Override
    public Record selectByPrimaryKey(Integer id) {
        return (Record) this.initData("selectByPrimaryKey", id);
    }
    @SbDataSource(DataSourceEnum.DB_SLAVE)
    @Override
    public List<Record> selectByExample(Example example) {
        return (List<Record>) this.initData("selectByExample", example);
    }

    @SbDataSource(DataSourceEnum.DB_SLAVE)
    @Override
    public int countByExample(Example example) {
        return (Integer) this.initData("countByExample", example);
    }

    @SbDataSource(DataSourceEnum.DB_MASTER)
    @Override
    public int deleteByExample(Example example) {
        return (Integer) this.initData("deleteByExample", example);
    }
    @SbDataSource(DataSourceEnum.DB_MASTER)
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return (Integer) this.initData("deleteByPrimaryKey", id);
    }
    @SbDataSource(DataSourceEnum.DB_MASTER)
    @Override
    public int insert(Record record) {
        return (Integer) this.initData("insert", record);
    }
    @SbDataSource(DataSourceEnum.DB_MASTER)
    @Override
    public int insertSelective(Record record) {
        return (Integer) this.initData("insertSelective", record);
    }
    @SbDataSource(DataSourceEnum.DB_MASTER)
    @Override
    public int updateByExampleSelective(@Param("record") Record record, @Param("example") Example example) {
        return (Integer) this.initData("updateByExampleSelective", record, example);
    }

    @SbDataSource(DataSourceEnum.DB_MASTER)
    @Override
    public int updateByExample(@Param("record") Record record, @Param("example") Example example) {
        return (Integer) this.initData("updateByExample", record, example);
    }
    @SbDataSource(DataSourceEnum.DB_MASTER)
    @Override
    public int updateByPrimaryKeySelective(Record record) {
        return (Integer) this.initData("updateByPrimaryKeySelective", record);
    }
    @SbDataSource(DataSourceEnum.DB_MASTER)
    @Override
    public int updateByPrimaryKey(Record record) {
        return (Integer) this.initData("updateByPrimaryKey", record);
    }

    public Object initData(String methodName, Object params) {
        try {
            Class<Mapper> mapperClass = (Class<Mapper>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
            Mapper mapper = SpringContextUtil.getBean(mapperClass);
            Method method = mapper.getClass().getDeclaredMethod(methodName, params.getClass());
            Object result = method.invoke(mapper, params);
            return result;
        } catch (Exception e) {
            return null;
        }
    }

    public Object initData(String methodName, Object params0, Object params1) {
        try {
            Class<Mapper> mapperClass = (Class<Mapper>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
            Mapper mapper = SpringContextUtil.getBean(mapperClass);
            Method method = mapper.getClass().getDeclaredMethod(methodName, params0.getClass(), params1.getClass());
            Object result = method.invoke(mapper, params0, params1);
            return result;
        } catch (Exception e) {
            return null;
        }
    }
}
