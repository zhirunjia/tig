package com.zhirunjia.housekeeper.Domain.Constants;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import android.app.Activity;

/**
 * Created by Xu wenQiang on 14-3-11.
 */
public class GlobalVarable {
	public static Map<String, Object> staticMap = new ConcurrentHashMap<String, Object>();
    public static Map<Class,Activity> activityMap = new ConcurrentHashMap<Class, Activity>();

 // 从连接池中取连接的超时时间
    public final static Integer CONN_MANAGER_TIMETOUT = 10000; //10s
    // 连接超时
    public final static Integer HTTP_CONNECT_TIMEOUT = 10000; //10s
    // 请求超时
    public final static Integer HTTP_SO_TIMEOUT = 10000; //10s
}
