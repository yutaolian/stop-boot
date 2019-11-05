package com.stopboot.admin.service.system.dictionary;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.stopboot.admin.common.PageResult;
import com.stopboot.admin.mapper.custom.system.dictionary.CustomSbDictionaryMapper;
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
import com.stopboot.admin.utils.BeansHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @description: Dictionary service
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


    @Resource
    private CustomSbDictionaryMapper customSbDictionaryMapper;


    @Override
    public PageResult<DictionaryPageVO> page(DictionaryPageParams pageParams) {
        SbDictionaryExample example = new SbDictionaryExample();
        SbDictionaryExample.Criteria criteria = example.createCriteria();
        if (!ObjectUtils.isEmpty(pageParams.getDicName())) {
            criteria.andDicNameEqualTo(pageParams.getDicName());
        }
        if (!ObjectUtils.isEmpty(pageParams.getDicKey())) {
            criteria.andDicKeyEqualTo(pageParams.getDicKey());
        }
        if (!ObjectUtils.isEmpty(pageParams.getStatus())) {
            criteria.andStatusEqualTo(pageParams.getStatus());
        }
        PageHelper.startPage(pageParams.getPageNum(), pageParams.getPageSize());
        List<SbDictionary> sbDictionaries = customSbDictionaryMapper.selectByExample(example);
        PageResult<SbDictionary> sbDictionaryPageResult = new PageResult<>(new PageInfo<>(sbDictionaries));
        PageResult<DictionaryPageVO> pageVOResult = BeansHelper.getInstance().convert(sbDictionaryPageResult, DictionaryPageVO.class);
        return pageVOResult;
    }

    @Override
    public List<DictionaryListVO> list(DictionaryListParams params) {
        SbDictionaryExample example = new SbDictionaryExample();
        SbDictionaryExample.Criteria criteria = example.createCriteria();
        if (!ObjectUtils.isEmpty(params.getDicKey())) {
            criteria.andDicKeyEqualTo(params.getDicKey());
            criteria.andDeleteFlagEqualTo(1);
            List<SbDictionary> sbDictionaries = this.selectByExample(example);
            return BeansHelper.getInstance().convert(sbDictionaries, DictionaryListVO.class);
        } else {
            return new ArrayList<>();
        }
    }

    @Override
    public boolean delete(DictionaryDeleteParams dictionaryDeleteParams) {
        DictionaryUpdateParams dictionaryUpdateParams = new DictionaryUpdateParams();
        dictionaryUpdateParams.setDeleteFlag(0);
        dictionaryUpdateParams.setUpdateTime(new Date());
        SbDictionaryExample example = new SbDictionaryExample();
        SbDictionaryExample.Criteria criteria = example.createCriteria();
        if (!ObjectUtils.isEmpty(dictionaryDeleteParams.getDicKey())) {
            criteria.andDicKeyEqualTo(dictionaryDeleteParams.getDicKey());
        }
        if (!ObjectUtils.isEmpty(dictionaryDeleteParams.getId())) {
            criteria.andIdEqualTo(dictionaryDeleteParams.getId());
        }
        return this.updateByExample(dictionaryUpdateParams, example);
    }

    @Override
    public boolean add(DictionaryAddParams params) {
        Date date = new Date();
        params.setCreateTime(date);
        params.setUpdateTime(date);
        params.setDeleteFlag(1);
        params.setStatus(1);
        return super.add(params);
    }

    @Override
    public boolean checkDicKey(DictionaryAddParams params) {
        String dicKey = params.getDicKey();
        if (!ObjectUtils.isEmpty(dicKey)) {
            SbDictionaryExample example = new SbDictionaryExample();
            SbDictionaryExample.Criteria criteria = example.createCriteria();
            criteria.andDicKeyEqualTo(dicKey);
            criteria.andDeleteFlagEqualTo(1);
            List<SbDictionary> sbDictionaries = this.selectByExample(example);
            return sbDictionaries.size() > 0 ? true : false;
        }
        return false;
    }
}
