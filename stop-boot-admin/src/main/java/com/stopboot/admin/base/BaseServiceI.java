package com.stopboot.admin.base;

import com.stopboot.admin.entity.SbMenu;
import com.stopboot.admin.entity.SbMenuExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @description:
 * @author: Lianyutao
 * @create: 2019-09-19 14:17
 * @version:
 **/

public interface BaseServiceI<Record,Example> {

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


}
