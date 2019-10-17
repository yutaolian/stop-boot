package com.stopboot.admin.generator;

import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: Lianyutao
 * @create: 2019-10-16 21:00
 * @version:
 **/

@Service
public class SbGeneratorStrategyContext {
    /**
     * 策略执行
     */
    public void execute(SbGeneratorStrategyParams strategyParam) {
        SbGeneratorStrategy strategy = null;
        boolean judge = strategy.judge(strategyParam);
        if (!judge) {
            return;
        }
        strategy.execute(strategyParam);
    }
}
