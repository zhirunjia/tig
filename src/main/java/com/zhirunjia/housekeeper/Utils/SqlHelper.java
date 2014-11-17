package com.zhirunjia.housekeeper.Utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

/**
 * Created by Xu wenQiang on 2014/5/12.
 */
public class SqlHelper {

    public static String createQuerySql(Object param, List<String> params) {
        try {
            StringBuilder querySql = new StringBuilder("SELECT ");
            StringBuilder whereSql = new StringBuilder(" WHERE 1=1 ");
            // 获得对象类型
            Class objClass = param.getClass();
            Field[] fields = objClass.getDeclaredFields();
            for (Field field : fields) {
                if (field.getType() == List.class) {
                    continue;
                }
                String fieldName = field.getName();
                // 获得和属性对应的getXXX()方法的名字
                String firstLetter = fieldName.substring(0, 1).toUpperCase();
                String getMethodName = "get" + firstLetter + fieldName.substring(1);
                Method getMethod = objClass.getMethod(getMethodName, new Class[]{});
                Object retObj = getMethod.invoke(param, new Object[]{});
                // 设置查询字段
                querySql.append(buildFieldSqlName(fieldName)).append(",");
                if (retObj != null) {
                    whereSql.append(" AND ").append(buildFieldSqlName(fieldName)).append("=?");
                    params.add(String.valueOf(retObj));
                }
            }
            String selectSql = querySql.substring(0, querySql.length() - 1) + " FROM  tb_" + param.getClass().getSimpleName().toLowerCase() + whereSql.toString();
            return selectSql;
        } catch (Throwable t) {
            t.printStackTrace();
        }
        return null;
    }

    public static String createInsertSql(Object param, List<Object> params) {
        try {
            StringBuilder insertSql = new StringBuilder("INSERT INTO tb_").append(param.getClass().getSimpleName().toLowerCase()).append("(");
            StringBuilder valuesSql = new StringBuilder(" VALUES(");
            // 获得对象类型
            Class objClass = param.getClass();
            Field[] fields = objClass.getDeclaredFields();
            for (Field field : fields) {
                if (field.getType() == List.class) {
                    continue;
                }
                String fieldName = field.getName();
                // 获得和属性对应的getXXX()方法的名字
                String firstLetter = fieldName.substring(0, 1).toUpperCase();
                String getMethodName = "get" + firstLetter + fieldName.substring(1);
                Method getMethod = objClass.getMethod(getMethodName, new Class[]{});
                Object retObj = getMethod.invoke(param, new Object[]{});
                if (retObj != null) {
                    // 设置查询字段
                    insertSql.append(buildFieldSqlName(fieldName)).append(",");
                    valuesSql.append("?,");
                    params.add(retObj);
                }
            }
            return insertSql.substring(0, insertSql.length() - 1) + ")" + valuesSql.substring(0, valuesSql.length() - 1) + ")";
        } catch (Throwable t) {
            t.printStackTrace();
        }
        return null;
    }

    public static String createUpdateSql(Object param, List<Object> params, String keyName) {
        try {
            StringBuilder updateSql = new StringBuilder("UPDATE tb_").append(param.getClass().getSimpleName().toLowerCase()).append(" SET ");
            StringBuilder whereSql = new StringBuilder(" WHERE ");
            // 获得对象类型
            Class objClass = param.getClass();
            Field[] fields = objClass.getDeclaredFields();
            Object keyValue = null;
            for (Field field : fields) {
                if (field.getType() == List.class) {
                    continue;
                }
                String fieldName = field.getName();
                // 获得和属性对应的getXXX()方法的名字
                String firstLetter = fieldName.substring(0, 1).toUpperCase();
                String getMethodName = "get" + firstLetter + fieldName.substring(1);
                Method getMethod = objClass.getMethod(getMethodName, new Class[]{});
                Object retObj = getMethod.invoke(param, new Object[]{});
                if (retObj != null) {
                    if (!keyName.equals(fieldName)) {
                        // 设置查询字段
                        updateSql.append(buildFieldSqlName(fieldName)).append("=?,");
                        params.add(retObj);
                    } else {
                        whereSql.append(buildFieldSqlName(fieldName)).append("=?");
                        keyValue = retObj;
                    }
                }
            }
            params.add(keyValue);
            return updateSql.substring(0, updateSql.length() - 1) + whereSql;
        } catch (Throwable t) {
            t.printStackTrace();
        }
        return null;
    }

    public static String createDeleteSql(Object param, List<Object> params) {
        try {
            // 获得对象类型
            Class objClass = param.getClass();
            StringBuilder deleteSql = new StringBuilder("DELETE FROM tb_").append(objClass.getSimpleName()).append(" WHERE 1=1");
            Field[] fields = objClass.getDeclaredFields();
            for (Field field : fields) {
                if (field.getType() == List.class) {
                    continue;
                }
                String fieldName = field.getName();
                // 获得和属性对应的getXXX()方法的名字
                String firstLetter = fieldName.substring(0, 1).toUpperCase();
                String getMethodName = "get" + firstLetter + fieldName.substring(1);
                Method getMethod = objClass.getMethod(getMethodName, new Class[]{});
                Object retObj = getMethod.invoke(param, new Object[]{});
                if (retObj != null) {
                    // 设置查询字段
                    deleteSql.append(" AND ").append(buildFieldSqlName(fieldName)).append("=?");
                    params.add(retObj);
                }
            }
            return deleteSql.toString();
        } catch (Throwable t) {
            t.printStackTrace();
        }
        return null;
    }


    public static String buildFieldSqlName(String name) {
        StringBuilder temp = new StringBuilder();
        int size = 0;
        for (int i = 0; i < name.length(); i++) {
            char c = name.charAt(i);
            if (Character.isUpperCase(c)) {
                temp.append(name.substring(size, i)).append("_").append(name.substring(i, i + 1).toLowerCase());
                size = i + 1;
            }
        }
        if (size < name.length()) {
            temp.append(name.substring(size, name.length()));
        }
        return temp.toString();
    }

}
