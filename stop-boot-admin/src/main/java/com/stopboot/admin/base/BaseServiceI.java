package com.stopboot.admin.base;

import com.stopboot.admin.common.PageResult;
import org.apache.ibatis.annotations.Param;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @description:
 * @author: Lianyutao
 * @create: 2019-09-19 14:17
 * @version:
 **/

public interface BaseServiceI<Record, Example> {

    //mybatis 工具自动生成方法
    Record selectByPrimaryKey(Integer id);

    List<Record> selectByExample(Example example);

    int countByExample(Example example);

    int deleteByExample(Example example);

    int deleteByPrimaryKey(Integer id);

    int insert(Record record);

    int insertSelective(Record record);

    int updateByExampleSelective(@Param("record") Record record, @Param("example") Example example);

    int updateByExample(@Param("record") Record record, @Param("example") Example example);

    int updateByPrimaryKeySelective(Record record);

    int updateByPrimaryKey(Record record);

    //自定义的方法

    PageResult<Record> pageByExample(Example example, Integer pageNum, Integer pageSize);

    PageResult<Record> pageWithBLOBsByExample(Example example, Integer pageNum, Integer pageSize);

}
