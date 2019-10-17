package com.stopboot.admin.base.cache;

import com.stopboot.admin.base.service.DefaultServiceI;
import com.stopboot.admin.utils.ClassUtil;
import com.stopboot.admin.utils.SpringContextUtil;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * @description:
 * @author: Lianyutao
 * @create: 2019-10-10 16:09
 * @version:
 **/

public abstract class AbstractCache<Service extends DefaultServiceI, KEY extends String, T extends Serializable> extends BaseCacheImpl<KEY, T> implements BaseCache<KEY, T> {

    /**
     * id作为key
     */
    private static final String ONE_BY_ID_KEY = "_one_id_";

    /**
     * tag作为key返回列表
     */
    private static final String LIST_BY_BIZ_KEY = "_list_tage";


    private Service service() {
        Class<Service> mapperClass = (Class<Service>) ClassUtil.getClass(getClass(), 0);
        Service service = SpringContextUtil.getBean(mapperClass);
        return service;
    }

    public T reloadOneCacheById(Integer id) {
        this.deleteOneCacheById(id);
        return getOneCacheById(id);
    }

    public boolean setOneCacheById(Integer id) {
        Service service = this.service();
        T o = (T) service.one(id);
        return this.set((KEY) makeKey(id, ONE_BY_ID_KEY), o);
    }


    public T getOneCacheById(Integer id) {
        return this.get(makeKey(id, ONE_BY_ID_KEY));
    }

    public void deleteOneCacheById(Integer id) {
        this.del(makeKey(id, ONE_BY_ID_KEY));
    }

    public boolean setOne(final KEY key, final T value) {
        return this.set(key, value);
    }

    public T loadOne(final KEY key) {
        Service service = this.service();
        return (T) service.one(Integer.parseInt(key));
    }

    public List<T> loadList(final KEY key) {

        return null;
    }

    public int cleanCache(final KEY key) {

        return 0;
    }

    private String makeKey(Integer id, String key) {
        Type type = ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];
        return type.getTypeName() + key + id;
    }


}
