package com.zhirunjia.housekeeper.Utils;

import android.content.Context;

import java.io.InputStream;
import java.util.Properties;

/**
 * 读取properties配置文件
 * Created by Xu wenQiang on 2014/3/21.
 */
public class PropertiesHelper {

    private static Object lock = new Object();

    public static Properties properties;

    private PropertiesHelper() {
    }

    public static void init(Context context) throws Exception {
        synchronized (lock) {
            if (null == properties) {
                properties = new Properties();
                InputStream is = context.getAssets().open("config.properties");
                properties.load(is);
            }
        }
    }

    public static String getValue(String key) throws Exception {
        return properties.getProperty(key);
    }

    public static String getValue(Context context, String key) throws Exception {

        if (null != properties) {
            return properties.getProperty(key);
        }

        synchronized (lock) {
            if (null == properties) {
                properties = new Properties();
                InputStream is = context.getAssets().open("config.properties");
                properties.load(is);
            }
        }

        return properties.getProperty(key);
    }


}
