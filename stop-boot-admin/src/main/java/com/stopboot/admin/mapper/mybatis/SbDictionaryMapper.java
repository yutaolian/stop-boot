package com.stopboot.admin.mapper.mybatis;

import com.stopboot.admin.entity.SbDictionary;
import com.stopboot.admin.entity.SbDictionaryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SbDictionaryMapper {
    int countByExample(SbDictionaryExample example);

    int deleteByExample(SbDictionaryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SbDictionary record);

    int insertSelective(SbDictionary record);

    List<SbDictionary> selectByExample(SbDictionaryExample example);

    SbDictionary selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SbDictionary record, @Param("example") SbDictionaryExample example);

    int updateByExample(@Param("record") SbDictionary record, @Param("example") SbDictionaryExample example);

    int updateByPrimaryKeySelective(SbDictionary record);

    int updateByPrimaryKey(SbDictionary record);
}