package com.zhirunjia.housekeeper.Utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import java.util.List;

/**
 * Created by Xu wenQiang on 14-6-11.
 */
public class WindowUtil {

    /**
     * 窗口跳转
     *
     * @param context 当前activity
     * @param cls 要显示的activity
     */
    public static void openWindow(Context context, Class<?> cls){
        Intent intent = new Intent(context, cls);
        context.startActivity(intent);
    }


    /**
     * 窗口跳转
     *
     * @param context 当前activity
     * @param cls 要显示的activity
     * @param activity 要关闭的activity
     */
    public static void openWindow(Context context, Class<?> cls, Activity activity){
        activity.finish();
        openWindow(context, cls);
    }

    /**
     * 窗口跳转
     *
     * @param context 当前activity
     * @param cls 要显示的activity
     * @param activityList 要关闭的activity列表
     */
    public static void openWindow(Context context, Class<?> cls, List<Activity> activityList){
        closeActivities(activityList);
        openWindow(context, cls);
    }

    /**
     * 窗口跳转
     *
     * @param context
     * @param intent 要启动的activity 包含要传递的参数
     * @param activityList 要关闭的activity
     */
    public static  void openWindow(Context context, Intent intent, List<Activity> activityList){
        closeActivities(activityList);
        context.startActivity(intent);
    }

    private static void closeActivities(List<Activity> activities){
        for(Activity activity:activities){
            activity.finish();
        }
    }
}
