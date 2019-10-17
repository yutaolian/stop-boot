package com.stopboot.admin.generator;

public interface SbGeneratorStrategy {

        /**
     * 策略条件判断
     *
     * @param marketStrategyParam
     * @return
     */
    boolean judge(SbGeneratorStrategyParams marketStrategyParam);


    /**
     * 策略执行方法
     *
     * @param marketStrategyParam
     * @return
     */
    void execute(SbGeneratorStrategyParams marketStrategyParam);
}
