package com.stopboot.admin.service.test2;/**
 * @version:0.0.1
 * @author: Lianyutao
 * @create: 2019-10-17 10:38
 * @description:
 **/

import com.stopboot.admin.base.service.DefaultSimpleServiceImpl;
import com.stopboot.admin.base.simple.BaseSimpleParams;
import com.stopboot.admin.entity.SbTest;
import com.stopboot.admin.entity.SbTestExample;
import com.stopboot.admin.mapper.mybatis.SbTestMapper;
import org.springframework.stereotype.Service;

/**
 * @version:0.0.1
 * @author: Lianyutao
 * @create: 2019-10-17 10:38
 * @description:
 **/

@Service
public class Test2ServiceImpl extends
        DefaultSimpleServiceImpl<SbTestMapper, SbTest, SbTestExample, SbTest, BaseSimpleParams>
        implements Test2ServiceI {
}
