package com.stopboot.admin.dao.mybatis.mapper;

import com.stopboot.admin.entity.SbDept;
import com.stopboot.admin.entity.SbDeptExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SbDeptMapper {
    int countByExample(SbDeptExample example);

    int deleteByExample(SbDeptExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SbDept record);

    int insertSelective(SbDept record);

    List<SbDept> selectByExample(SbDeptExample example);

    SbDept selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SbDept record, @Param("example") SbDeptExample example);

    int updateByExample(@Param("record") SbDept record, @Param("example") SbDeptExample example);

    int updateByPrimaryKeySelective(SbDept record);

    int updateByPrimaryKey(SbDept record);
}