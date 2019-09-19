package com.stopboot.admin.db;

/**
 * @description:
 * @author: Lianyutao
 * @create: 2019-09-19 14:57
 * @version:
 **/

public class DynamicDataSourceContextHolder {

    private static final ThreadLocal<DataSourceEnum> currentDatesource = new ThreadLocal<>();

    /**
     * 清除当前数据源
     */
    public static void clear() {
        currentDatesource.remove();
    }

    /**
     * 获取当前使用的数据源
     *
     * @return 当前使用数据源的ID
     */
    public static DataSourceEnum get() {
        return currentDatesource.get();
    }

    /**
     * 设置当前使用的数据源
     *
     * @param value 需要设置的数据源ID
     */
    public static void set(DataSourceEnum value) {
        currentDatesource.set(value);
    }

    /**
     * 设置从从库读取数据
     */
    public static void setSlave() {
        DynamicDataSourceContextHolder.set(DataSourceEnum.DB_SLAVE);
    }
    /**
     * 设置Log数据库
     */
    public static void setLog() {
        DynamicDataSourceContextHolder.set(DataSourceEnum.DB_LOG);
    }

}
