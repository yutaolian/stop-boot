package com.stopboot.admin.service.admin.impl;

import com.stopboot.admin.base.*;
import com.stopboot.admin.dao.mybatis.mapper.SbTestMapper;
import com.stopboot.admin.entity.SbTest;
import com.stopboot.admin.entity.SbTestExample;
import com.stopboot.admin.model.test.add.TestAddParams;
import com.stopboot.admin.model.test.detail.TestOneParams;
import com.stopboot.admin.model.test.detail.TestOneVO;
import com.stopboot.admin.model.test.list.TestListParams;
import com.stopboot.admin.model.test.list.TestListVO;
import com.stopboot.admin.model.test.page.TestPageParams;
import com.stopboot.admin.model.test.page.TestPageVO;
import com.stopboot.admin.model.test.update.TestUpdateParams;
import com.stopboot.admin.service.admin.AdminServiceI;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


/**
 * @description:
 * @author: Lianyutao
 * @create: 2019-09-19 11:18
 * @version:
 **/

@Slf4j
@Service
public class AdminServiceImpl extends ListServiceImpl<SbTestMapper, SbTest, SbTestExample, TestPageVO, TestListVO, TestOneVO, TestPageParams, TestListParams, TestOneParams, TestAddParams, TestUpdateParams> implements AdminServiceI {


}
