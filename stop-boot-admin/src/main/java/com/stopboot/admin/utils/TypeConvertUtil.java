package com.stopboot.admin.utils;

/**
 * @version:0.0.1
 * @author: Lianyutao
 * @create: 2019-10-25 13:00
 * @description: mysql类型转换工具类
 **/

public class TypeConvertUtil {

    /**
     * mysql的类型转为java类型
     *
     * @param mysqlType
     * @return
     */
    public static String mysqlTypeToJava(String mysqlType) {

        if (mysqlType == null || mysqlType.trim().length() == 0) {
            return mysqlType;
        }
        //转为小写
        mysqlType = mysqlType.toLowerCase();
        switch (mysqlType) {
            case "bigint":
                return "java.math.BigInteger";
            case "binary":
                return "java.math.BigInteger";
            case "nvarchar":
                return "String";
            case "char":
                return "String";
            case "varchar":
                return "String";
            case "text":
                return "String";
            case "nchar":
                return "String";
            case "blob":
                return "byte[]";
            case "integer":
                return "Long";
            case "int":
                return "Integer";
            case "tinyint":
                return "Integer";
            case "smallint":
                return "Integer";
            case "mediumint":
                return "Integer";
            case "bit":
                return "Boolean";
            case "float":
                return "Float";
            case "double":
                return "Double";
            case "decimal":
                return "java.math.BigDecimal";
            case "boolean":
                return "Boolean";
            case "id":
                return "Long";
            case "date":
                return "java.util.Date";
            case "datetime":
                return "java.util.Date";
            case "year":
                return "java.util.Date";
            case "time":
                return "java.sql.Time";
            case "timestamp":
                return "java.sql.Timestamp";
            case "numeric":
                return "java.math.BigDecimal";
            case "real":
                return "java.math.BigDecimal";
            case "money":
                return "Double";
            case "smallmoney":
                return "Double";
            case "image":
                return "byte[]";
            default:
                //上述类型都没有返回Object类型
                return "Object";
        }
    }
}
