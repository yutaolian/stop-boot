package com.stopboot.admin.generator.impl.js;


import com.stopboot.admin.generator.SbGeneratorStrategy;
import com.stopboot.admin.generator.SbGeneratorStrategyParams;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: Lianyutao
 * @create: 2019-10-16 21:06
 * @version:
 **/
@Service
public class SbJsGeneratorStrategyImpl implements SbGeneratorStrategy {

    @Override
    public boolean judge(SbGeneratorStrategyParams marketStrategyParam) {
        return false;
    }

    @Override
    public void execute(SbGeneratorStrategyParams marketStrategyParam) {

    }
}
