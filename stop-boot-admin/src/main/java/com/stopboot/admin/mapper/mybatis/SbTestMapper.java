package com.stopboot.admin.mapper.mybatis;

import com.stopboot.admin.entity.SbTest;
import com.stopboot.admin.entity.SbTestExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SbTestMapper {
    int countByExample(SbTestExample example);

    int deleteByExample(SbTestExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SbTest record);

    int insertSelective(SbTest record);

    List<SbTest> selectByExampleWithBLOBs(SbTestExample example);

    List<SbTest> selectByExample(SbTestExample example);

    SbTest selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SbTest record, @Param("example") SbTestExample example);

    int updateByExampleWithBLOBs(@Param("record") SbTest record, @Param("example") SbTestExample example);

    int updateByExample(@Param("record") SbTest record, @Param("example") SbTestExample example);

    int updateByPrimaryKeySelective(SbTest record);

    int updateByPrimaryKeyWithBLOBs(SbTest record);

    int updateByPrimaryKey(SbTest record);
}