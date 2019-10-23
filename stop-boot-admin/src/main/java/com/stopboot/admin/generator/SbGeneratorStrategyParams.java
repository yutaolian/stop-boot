package com.stopboot.admin.generator;

import com.stopboot.admin.model.help.generator.BaseInfo;
import lombok.Data;

import java.util.Map;

/**
 * @description: 存放生成代码的全部数据
 * @author: Lianyutao
 * @create: 2019-10-16 21:00
 * @version:
 **/

@Data
public class SbGeneratorStrategyParams {

    private String name;

    private BaseInfo baseInfo;

    private Map<String, Object> data;

    //source

    //target

    public SbGeneratorStrategyParams(String name, BaseInfo baseInfo, Map<String, Object> data) {
        this.name = name;
        this.baseInfo = baseInfo;
        this.data = data;
    }
}


