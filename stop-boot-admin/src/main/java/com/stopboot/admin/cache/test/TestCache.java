package com.stopboot.admin.cache.test;

import com.stopboot.admin.cache.AbstractCache;
import com.stopboot.admin.entity.SbTest;
import com.stopboot.admin.service.test.TestServiceI;
import org.springframework.stereotype.Service;


/**
 * @description:
 * @author: Lianyutao
 * @create: 2019-10-10 16:15
 * @version:
 **/

@Service
public class TestCache extends AbstractCache<String, SbTest, TestServiceI> {

}
