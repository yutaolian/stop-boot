package com.stopboot.admin.base.cache;

import java.io.Serializable;
import java.util.Date;

/**
 * @description: 需对象可以序列化
 * @author: Lianyutao
 * @create: 2019-10-10 15:42
 * @version:
 **/

public interface BaseCache<KEY extends String, T extends Serializable> {

    /**
     * 设置key expire 秒过期时间
     *
     * @param key
     * @param expire 秒
     * @return
     */
    default boolean expire(final KEY key, final Long expire){
        return false;
    }


    /**
     * 指定key的过期时间为date
     *
     * @param key
     * @param date 时间
     * @return
     */
    default boolean expireAt(final KEY key, final Date date){
        return false;
    }

    /**
     * 获得一个对象
     *
     * @param key
     * @return
     */
    default T get(final KEY key){
        return null;
    }

    /**
     * 添加一个对象
     * @param key
     * @param value
     * @return
     */
    default boolean set(final KEY key, final T value){
        return false;
    }

    /**
     * 添加一个对象 含过期时间
     *
     * @param key
     * @param value
     * @param expire
     * @return
     */
    default boolean set(final KEY key, final T value, final Long expire){
        return false;
    }


    /**
     * key是否存在
     * @param key
     * @return
     */
    default boolean hasKey(final KEY key){
        return false;
    }

    /**
     * 删除key
     *
     * @param key
     */
    default void del(String... key){}


}
