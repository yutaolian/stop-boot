package com.stopboot.admin.service.admin;

import com.stopboot.admin.base.service.DefaultListServiceImpl;
import com.stopboot.admin.entity.SbTest;
import com.stopboot.admin.entity.SbTestExample;
import com.stopboot.admin.mapper.mybatis.SbTestMapper;
import com.stopboot.admin.model.test.add.TestAddParams;
import com.stopboot.admin.model.test.delete.TestDeleteParams;
import com.stopboot.admin.model.test.one.TestOneParams;
import com.stopboot.admin.model.test.one.TestOneVO;
import com.stopboot.admin.model.test.list.TestListParams;
import com.stopboot.admin.model.test.list.TestListVO;
import com.stopboot.admin.model.test.page.TestPageParams;
import com.stopboot.admin.model.test.page.TestPageVO;
import com.stopboot.admin.model.test.update.TestUpdateParams;
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
public class AdminServiceImpl extends DefaultListServiceImpl<SbTestMapper, SbTest, SbTestExample, TestPageVO, TestListVO, TestOneVO, TestPageParams, TestListParams, TestOneParams, TestAddParams, TestUpdateParams, TestDeleteParams> implements AdminServiceI {


}
