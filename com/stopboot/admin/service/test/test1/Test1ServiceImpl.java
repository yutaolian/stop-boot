package com.stopboot.admin.service.test.test1;

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
 * @create: 2019/10/24 22:03
 * @version: 1.0.1
**/

@Slf4j
@Service
public class Test1ServiceImpl extends DefaultServiceImpl<SbTestMapper, SbTest, SbTestExample,
                                Test1PageVO, Test1OneVO,
                                Test1PageParams, Test1OneParams,
                                Test1AddParams, Test1UpdateParams, Test1DeleteParams>
                                implements Test1ServiceI {



}
