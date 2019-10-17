package com.stopboot.admin.base.service;

import com.stopboot.admin.common.PageResult;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @description: mybatis 工具自动生成方法
 * @author: Lianyutao
 * @create: 2019-09-19 14:17
 * @version:
 **/

public interface BaseServiceI<DBRecord, DBExample> {
    /**
     *
     */
    default int countByExample(DBExample example) {
        return 0;
    }

    default int deleteByExample(DBExample example) {
        return 0;
    }

    default int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    default int insert(DBRecord record) {
        return 0;
    }

    default int insertSelective(DBRecord record) {
        return 0;
    }

    default List<DBRecord> selectByExampleWithBLOBs(DBExample example) {
        return null;
    }

    default List<DBRecord> selectByExample(DBExample example) {
        return null;
    }

    default DBRecord selectByPrimaryKey(Integer id) {
        return null;
    }

    default int updateByExampleSelective(@Param("record") DBRecord record, @Param("example") DBExample example) {
        return 0;
    }

    default int updateByExampleWithBLOBs(@Param("record") DBRecord record, @Param("example") DBExample example) {
        return 0;
    }

    default int updateByExample(@Param("record") DBRecord record, @Param("example") DBExample example) {
        return 0;
    }

    default int updateByPrimaryKeySelective(DBRecord record) {
        return 0;
    }

    default int updateByPrimaryKeyWithBLOBs(DBRecord record) {
        return 0;
    }

    default int updateByPrimaryKey(DBRecord record) {
        return 0;
    }

    //自定义的方法

    default PageResult<DBRecord> pageByExample(DBExample example, Integer pageNum, Integer pageSize) {
        return null;
    }

    default PageResult<DBRecord> pageWithBLOBsByExample(DBExample example, Integer pageNum, Integer pageSize) {
        return null;
    }

}
