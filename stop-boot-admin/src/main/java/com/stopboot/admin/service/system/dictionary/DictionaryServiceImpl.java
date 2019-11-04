package com.stopboot.admin.service.system.dictionary;

import com.stopboot.admin.common.PageResult;
import com.stopboot.admin.mapper.mybatis.SbDictionaryMapper;
import com.stopboot.admin.entity.SbDictionary;
import com.stopboot.admin.entity.SbDictionaryExample;
import com.stopboot.admin.base.service.DefaultServiceImpl;
import com.stopboot.admin.model.system.dictionary.add.DictionaryAddParams;
import com.stopboot.admin.model.system.dictionary.list.DictionaryListVO;
import com.stopboot.admin.model.system.dictionary.list.DictionaryListParams;
import com.stopboot.admin.model.system.dictionary.one.DictionaryOneParams;
import com.stopboot.admin.model.system.dictionary.one.DictionaryOneVO;
import com.stopboot.admin.model.system.dictionary.page.DictionaryPageParams;
import com.stopboot.admin.model.system.dictionary.page.DictionaryPageVO;
import com.stopboot.admin.model.system.dictionary.update.DictionaryUpdateParams;
import com.stopboot.admin.model.system.dictionary.delete.DictionaryDeleteParams;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

/**
 * @description:  Dictionary service
 * @author: Lianyutao
 * @create: 2019/11/04 19:54
 * @version: 1.0.1
**/

@Slf4j
@Service
public class DictionaryServiceImpl extends DefaultServiceImpl<SbDictionaryMapper, SbDictionary, SbDictionaryExample,
        DictionaryPageVO, DictionaryListVO, DictionaryOneVO,
        DictionaryPageParams, DictionaryListParams, DictionaryOneParams,
        DictionaryAddParams, DictionaryUpdateParams, DictionaryDeleteParams>
        implements DictionaryServiceI {


    @Override
    public PageResult<DictionaryPageVO> page(DictionaryPageParams pageParams) {
        SbDictionaryExample example = new SbDictionaryExample();
        SbDictionaryExample.Criteria criteria = example.createCriteria();
        if (!ObjectUtils.isEmpty(pageParams.getId())) {
            criteria.andIdEqualTo(pageParams.getId());
        }
        if (!ObjectUtils.isEmpty(pageParams.getDicName())) {
            criteria.andDicNameEqualTo(pageParams.getDicName());
        }
        if (!ObjectUtils.isEmpty(pageParams.getDicKey())) {
            criteria.andDicKeyEqualTo(pageParams.getDicKey());
        }
        if (!ObjectUtils.isEmpty(pageParams.getDicValue())) {
            criteria.andDicValueEqualTo(pageParams.getDicValue());
        }
        if (!ObjectUtils.isEmpty(pageParams.getDicDesc())) {
            criteria.andDicDescEqualTo(pageParams.getDicDesc());
        }
        if (!ObjectUtils.isEmpty(pageParams.getStatus())) {
            criteria.andStatusEqualTo(pageParams.getStatus());
        }
        if (!ObjectUtils.isEmpty(pageParams.getDeleteFlag())) {
            criteria.andDeleteFlagEqualTo(pageParams.getDeleteFlag());
        }
        if (!ObjectUtils.isEmpty(pageParams.getCreateTime())) {
            criteria.andCreateTimeEqualTo(pageParams.getCreateTime());
        }
        if (!ObjectUtils.isEmpty(pageParams.getUpdateTime())) {
            criteria.andUpdateTimeEqualTo(pageParams.getUpdateTime());
        }
        return this.pageByExample(pageParams, example);
    }

}
