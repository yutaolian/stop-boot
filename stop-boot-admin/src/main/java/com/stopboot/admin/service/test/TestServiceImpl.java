package com.stopboot.admin.service.test;

import com.stopboot.admin.base.service.BaseServiceImpl;
import com.stopboot.admin.base.service.DefaultServiceI;
import com.stopboot.admin.base.vo.BaseVO;
import com.stopboot.admin.common.PageResult;
import com.stopboot.admin.entity.SbTest;
import com.stopboot.admin.entity.SbTestExample;
import com.stopboot.admin.mapper.mybatis.SbTestMapper;
import com.stopboot.admin.model.test.add.TestAddParams;
import com.stopboot.admin.model.test.delete.TestDeleteParams;
import com.stopboot.admin.model.test.list.TestListParams;
import com.stopboot.admin.model.test.one.TestOneParams;
import com.stopboot.admin.model.test.one.TestOneVO;
import com.stopboot.admin.model.test.page.TestPageParams;
import com.stopboot.admin.model.test.page.TestPageVO;
import com.stopboot.admin.model.test.update.TestUpdateParams;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;


/**
 * @description:
 * @author: Lianyutao
 * @create: 2019-09-19 11:18
 * @version:
 **/

@Slf4j
@Service
public class TestServiceImpl implements TestServiceI{
//
//    @Override
//    public PageResult<TestPageVO> page(TestPageParams pageParams) {
//        SbTestExample example = new SbTestExample();
//        SbTestExample.Criteria criteria = example.createCriteria();
//        if (!ObjectUtils.isEmpty(pageParams.getAge())) {
//            criteria.andAgeEqualTo(pageParams.getAge());
//        }
//        if (!ObjectUtils.isEmpty(pageParams.getName())) {
//            criteria.andNameEqualTo(pageParams.getName());
//        }
//        return this.pageByExample(pageParams, example);
//    }
//
//
//    @Override
//    public TestOneVO oneWithBLOBs(TestOneParams params) {
//        return null;
//    }
}
