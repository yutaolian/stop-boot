package com.stopboot.admin.base;

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
    boolean expire(final KEY key, final Long expire);


    /**
     * 指定key的过期时间为date
     *
     * @param key
     * @param date 时间
     * @return
     */
    boolean expireAt(final KEY key, final Date date);

    /**
     * 获得一个对象
     *
     * @param key
     * @return
     */
    T get(final KEY key);

    /**
     * 添加一个对象
     *
     * @param key
     * @param value
     */
    boolean set(final KEY key, final T value);

    /**
     * 添加一个对象 含过期时间
     *
     * @param key
     * @param value
     * @param expire
     */
    boolean set(final KEY key, final T value, final Long expire);


    /**
     * key是否存在
     * @param key
     * @return
     */
    boolean hasKey(final KEY key);

    /**
     * 删除key
     *
     * @param key
     */
    void del(String... key);


}
