package com.stopboot.admin.base.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.stopboot.admin.annotation.InvokeTime;
import com.stopboot.admin.annotation.SbDataSource;
import com.stopboot.admin.common.PageResult;
import com.stopboot.admin.config.DataSourceEnum;
import com.stopboot.admin.utils.ClassUtil;
import com.stopboot.admin.utils.SpringContextUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @description: 事务需要加到对应实现类的方法上，否则不起作用
 * 该方法参考开源项目：zheng
 * 此处将Mapper Example改名字是为了后续扩展不会与mybatis中的Mapper Example冲突
 * @author: Lianyutao
 * @create: 2019-09-19 14:17
 * @version:
 **/

@Slf4j
public class BaseServiceImpl<DBMapper, DBRecord, DBExample> implements BaseServiceI<DBRecord, DBExample> {

    private static final int MAPPER_INDEX = 0;
    private static final int EXAMPLE_INDEX = 2;

    /**
     * 数量
     *
     * @param example
     * @return
     */
    @SbDataSource(DataSourceEnum.DB_MASTER)
    @Override
    public int countByExample(DBExample example) {
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
    public int deleteByExample(DBExample example) {
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
    public int insert(DBRecord record) {
        return (Integer) this.execute("insert", record);
    }

    @SbDataSource(DataSourceEnum.DB_MASTER)
    @Override
    public int insertSelective(DBRecord record) {
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
    public DBRecord selectByPrimaryKey(Integer id) {
        return (DBRecord) this.execute("selectByPrimaryKey", id);
    }

    @InvokeTime()
    @SbDataSource(DataSourceEnum.DB_MASTER)
    @Override
    public List<DBRecord> selectByExampleWithBLOBs(DBExample example) {
        return (List<DBRecord>) this.execute("selectByExampleWithBLOBs", example);
    }

    @InvokeTime()
    @SbDataSource(DataSourceEnum.DB_MASTER)
    @Override
    public List<DBRecord> selectByExample(DBExample example) {
        return (List<DBRecord>) this.execute("selectByExample", example);
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
    public int updateByExampleSelective(@Param("record") DBRecord record, @Param("example") DBExample example) {
        return (Integer) this.execute("updateByExampleSelective", record, example);
    }

    @SbDataSource(DataSourceEnum.DB_MASTER)
    @Override
    public int updateByExample(@Param("record") DBRecord record, @Param("example") DBExample example) {
        return (Integer) this.execute("updateByExample", record, example);
    }

    @SbDataSource(DataSourceEnum.DB_MASTER)
    @Override
    public int updateByExampleWithBLOBs(DBRecord record, DBExample example) {
        return (Integer) this.execute("updateByExampleWithBLOBs", record, example);
    }

    @SbDataSource(DataSourceEnum.DB_MASTER)
    @Override
    public int updateByPrimaryKeyWithBLOBs(DBRecord record) {
        return (Integer) this.execute("updateByPrimaryKeyWithBLOBs", record);
    }

    @SbDataSource(DataSourceEnum.DB_MASTER)
    @Override
    public int updateByPrimaryKeySelective(DBRecord record) {
        return (Integer) this.execute("updateByPrimaryKeySelective", record);
    }

    @SbDataSource(DataSourceEnum.DB_MASTER)
    @Override
    public int updateByPrimaryKey(DBRecord record) {
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
    public PageResult<DBRecord> pageByExample(DBExample example, Integer pageNum, Integer pageSize) {
        List<DBRecord> list = this.executePage("selectByExample", example, pageNum, pageSize);
        return new PageResult<>(new PageInfo<>(list));
    }

    @SbDataSource(DataSourceEnum.DB_MASTER)
    @Override
    public PageResult<DBRecord> pageWithBLOBsByExample(DBExample example, Integer pageNum, Integer pageSize) {
        List<DBRecord> list = this.executePage("selectByExampleWithBLOBs", example, pageNum, pageSize);
        return new PageResult<>(new PageInfo<>(list));
    }


    public Object execute(String methodName, Object params) {
        try {
            DBMapper mapper = this.mapper();
            Method method = mapper.getClass().getDeclaredMethod(methodName, params.getClass());
            return method.invoke(mapper, params);
        } catch (Exception e) {
            log.error("BaseServiceImpl execute invoke error:{}", e.fillInStackTrace());
            return null;
        }
    }

    public Object execute(String methodName, Object record, DBExample example) {
        try {
            DBMapper mapper = this.mapper();
            if (example == null) {
                Class<DBExample> exampleClass = (Class<DBExample>) ClassUtil.getClass(getClass(), EXAMPLE_INDEX);
                example = exampleClass.newInstance();
            }
            Method method = mapper.getClass().getDeclaredMethod(methodName, record.getClass(), example.getClass());
            return method.invoke(mapper, record, example);
        } catch (Exception e) {
            log.error("BaseServiceImpl execute invoke error:{}", e.getMessage());
            return null;
        }
    }

    public List<DBRecord> executePage(String methodName, DBExample example, Integer pageNum, Integer pageSize) {
        try {
            DBMapper mapper = this.mapper();
            if (example == null) {
                Class<DBExample> exampleClass = (Class<DBExample>) ClassUtil.getClass(getClass(), EXAMPLE_INDEX);
                example = exampleClass.newInstance();
            }
            Method method = mapper.getClass().getDeclaredMethod(methodName, example.getClass());
            PageHelper.startPage(pageNum, pageSize);
            return (List<DBRecord>) method.invoke(mapper, example);
        } catch (Exception e) {
            log.error("BaseServiceImpl executePage invoke error:{}", e.getMessage());
            return new ArrayList<>();
        }
    }

    private DBMapper mapper() {
        Class<DBMapper> mapperClass = (Class<DBMapper>) ClassUtil.getClass(getClass(), MAPPER_INDEX);
        DBMapper mapper = SpringContextUtil.getBean(mapperClass);
        return mapper;
    }
}
