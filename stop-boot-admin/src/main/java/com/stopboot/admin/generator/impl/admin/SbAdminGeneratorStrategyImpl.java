package com.stopboot.admin.generator.impl.admin;/**
 * @version:0.0.1
 * @author: Lianyutao
 * @create: 2019-10-23 10:01
 * @description:
 **/

import com.stopboot.admin.generator.SbGeneratorStrategy;
import com.stopboot.admin.generator.SbGeneratorStrategyParams;
import org.springframework.stereotype.Service;

/**
 * @version:0.0.1
 * @author: Lianyutao
 * @create: 2019-10-23 10:01
 * @description: 生成后台逻辑代码
 **/
@Service
public class SbAdminGeneratorStrategyImpl implements SbGeneratorStrategy {

    @Override
    public boolean judge(SbGeneratorStrategyParams marketStrategyParam) {
        return false;
    }

    @Override
    public void execute(SbGeneratorStrategyParams marketStrategyParam) {

    }
}
