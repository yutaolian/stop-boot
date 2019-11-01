package com.stopboot.admin.service.test.test2.test22;

import com.stopboot.admin.common.PageResult;
import com.stopboot.admin.mapper.mybatis.SbTestMapper;
import com.stopboot.admin.entity.SbTest;
import com.stopboot.admin.entity.SbTestExample;
import com.stopboot.admin.base.service.DefaultServiceImpl;
import com.stopboot.admin.model.test.test2.test22.add.Test22AddParams;
import com.stopboot.admin.model.test.test2.test22.list.Test22ListVO;
import com.stopboot.admin.model.test.test2.test22.list.Test22ListParams;
import com.stopboot.admin.model.test.test2.test22.one.Test22OneParams;
import com.stopboot.admin.model.test.test2.test22.one.Test22OneVO;
import com.stopboot.admin.model.test.test2.test22.page.Test22PageParams;
import com.stopboot.admin.model.test.test2.test22.page.Test22PageVO;
import com.stopboot.admin.model.test.test2.test22.update.Test22UpdateParams;
import com.stopboot.admin.model.test.test2.test22.delete.Test22DeleteParams;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

/**
 * @description:  Test22 service
 * @author: Lianyutao
 * @create: 2019/11/01 17:09
 * @version: 1.0.1
**/

@Slf4j
@Service
public class Test22ServiceImpl extends DefaultServiceImpl<SbTestMapper, SbTest, SbTestExample,
        Test22PageVO, Test22ListVO, Test22OneVO,
        Test22PageParams, Test22ListParams, Test22OneParams,
        Test22AddParams, Test22UpdateParams, Test22DeleteParams>
        implements Test22ServiceI {


    @Override
    public PageResult<Test22PageVO> page(Test22PageParams pageParams) {
        SbTestExample example = new SbTestExample();
        SbTestExample.Criteria criteria = example.createCriteria();
        if (!ObjectUtils.isEmpty(pageParams.getId())) {
            criteria.andIdEqualTo(pageParams.getId());
        }
        if (!ObjectUtils.isEmpty(pageParams.getName())) {
            criteria.andNameEqualTo(pageParams.getName());
        }
        if (!ObjectUtils.isEmpty(pageParams.getAge())) {
            criteria.andAgeEqualTo(pageParams.getAge());
        }
        if (!ObjectUtils.isEmpty(pageParams.getBirthday())) {
            criteria.andBirthdayEqualTo(pageParams.getBirthday());
        }
        if (!ObjectUtils.isEmpty(pageParams.getCreateTime())) {
            criteria.andCreateTimeEqualTo(pageParams.getCreateTime());
        }
        if (!ObjectUtils.isEmpty(pageParams.getStatus())) {
            criteria.andStatusEqualTo(pageParams.getStatus());
        }
        if (!ObjectUtils.isEmpty(pageParams.getHeadImg())) {
            criteria.andHeadImgEqualTo(pageParams.getHeadImg());
        }
        if (!ObjectUtils.isEmpty(pageParams.getDeleteFlag())) {
            criteria.andDeleteFlagEqualTo(pageParams.getDeleteFlag());
        }
        if (!ObjectUtils.isEmpty(pageParams.getUpdateTime())) {
            criteria.andUpdateTimeEqualTo(pageParams.getUpdateTime());
        }
        return this.pageByExample(pageParams, example);
    }

}
