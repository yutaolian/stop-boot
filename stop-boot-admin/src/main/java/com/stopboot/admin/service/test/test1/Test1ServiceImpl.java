package com.stopboot.admin.service.test.test1;

import com.stopboot.admin.common.PageResult;
import com.stopboot.admin.mapper.mybatis.SbTestMapper;
import com.stopboot.admin.entity.SbTest;
import com.stopboot.admin.entity.SbTestExample;
import com.stopboot.admin.base.service.DefaultServiceImpl;
import com.stopboot.admin.model.test.test1.add.Test1AddParams;
import com.stopboot.admin.model.test.test1.one.Test1OneParams;
import com.stopboot.admin.model.test.test1.one.Test1OneVO;
import com.stopboot.admin.model.test.test1.page.Test1PageParams;
import com.stopboot.admin.model.test.test1.page.Test1PageVO;
import com.stopboot.admin.model.test.test1.update.Test1UpdateParams;
import com.stopboot.admin.model.test.test1.delete.Test1DeleteParams;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


/**
 * @description:  Test1 service
 * @author: Lianyutao
 * @create: 2019/10/25 19:02
 * @version: 1.0.1
**/

@Slf4j
@Service
public class Test1ServiceImpl extends DefaultServiceImpl<SbTestMapper, SbTest, SbTestExample,
                                Test1PageVO, Test1OneVO,
                                Test1PageParams, Test1OneParams,
                                Test1AddParams, Test1UpdateParams, Test1DeleteParams>
                                implements Test1ServiceI {


    @Override
    public PageResult<Test1PageVO> page(Test1PageParams pageParams) {
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
        if (!ObjectUtils.isEmpty(pageParams.getInfo())) {
            criteria.andInfoEqualTo(pageParams.getInfo());
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
