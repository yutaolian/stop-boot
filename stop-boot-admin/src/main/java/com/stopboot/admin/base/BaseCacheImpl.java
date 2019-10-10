package com.stopboot.admin.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.io.Serializable;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: Lianyutao
 * @create: 2019-10-10 16:07
 * @version:
 **/

@Component
public abstract class BaseCacheImpl<KEY extends String, T extends Serializable> implements BaseCache<KEY, T> {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Override
    public boolean expire(KEY key, Long expire) {
        try {
            if (expire > 0) {
                redisTemplate.expire(key, expire, TimeUnit.SECONDS);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    @Override
    public boolean expireAt(KEY key, Date date) {
        try {
            if (date != null) {
                redisTemplate.expireAt(key, date);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public T get(String key) {
        return key == null ? null : (T) redisTemplate.opsForValue().get(key);
    }

    @Override
    public boolean set(KEY key, T value) {
        try {
            redisTemplate.opsForValue().set(key, value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean set(KEY key, T value, Long expire) {
        try {
            redisTemplate.opsForValue().set(key, value, expire, TimeUnit.SECONDS);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean hasKey(KEY key) {
        try {
            return redisTemplate.hasKey(key);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public void del(String... key) {
        if (key != null && key.length > 0) {
            if (key.length == 1) {
                redisTemplate.delete(key[0]);
            } else {
                redisTemplate.delete(CollectionUtils.arrayToList(key));
            }
        }
    }
}
