package com.stopboot.admin.strategy.generator;

import com.stopboot.admin.model.help.generator.GeneratorInfo;
import lombok.Data;

/**
 * @description: 存放生成代码的全部数据
 * @author: Lianyutao
 * @create: 2019-10-16 21:00
 * @version:
 **/

@Data
public class SbGeneratorStrategyParams {

    private SbGeneratorStrategy sbGeneratorStrategy;

    private GeneratorInfo generatorInfo;

    public SbGeneratorStrategyParams(SbGeneratorStrategy sbGeneratorStrategy, GeneratorInfo generatorInfo) {
        this.sbGeneratorStrategy = sbGeneratorStrategy;
        this.generatorInfo = generatorInfo;
    }
}


