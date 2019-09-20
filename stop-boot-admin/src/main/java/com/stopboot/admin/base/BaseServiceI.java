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

    //mybatis 工具自动生成
    Record selectByPrimaryKey(@NotNull Integer id);

    List<Record> selectByExample(@NotNull Example example);

    int countByExample(Example example);

    int deleteByExample(Example example);

    int deleteByPrimaryKey(Integer id);

    int insert(Record record);

    int insertSelective(Record record);

    int updateByExampleSelective(@Param("record") Record record, @Param("example") Example example);

    int updateByExample(@NotNull @Param("record") Record record, @NotNull @Param("example") Example example);

    int updateByPrimaryKeySelective(Record record);

    int updateByPrimaryKey(Record record);

    //自定义的方法

    PageResult<Record> pageByExample(@NotNull Example example, @NotNull Integer pageSize, @NotNull Integer pageNum);

    PageResult<Record> pageWithBLOBsByExample(@NotNull Example example, @NotNull Integer pageSize, @NotNull Integer pageNum);

}
