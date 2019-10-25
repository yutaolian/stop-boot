package com.stopboot.admin.strategy.generator;

/**
 * @version:0.0.1
 * @author: Lianyutao
 * @create: 2019-10-23 10:01
 * @description: 生成后台逻辑代码
 **/
public interface SbGeneratorStrategy {

        /**
     * 策略条件判断
     *
     * @param marketStrategyParam
     * @return
     */
   default boolean judge(SbGeneratorStrategyParams marketStrategyParam){
       return false;
   }


    /**
     * 策略执行方法
     *
     * @param marketStrategyParam
     * @return
     */
   default void execute(SbGeneratorStrategyParams marketStrategyParam){}
}
