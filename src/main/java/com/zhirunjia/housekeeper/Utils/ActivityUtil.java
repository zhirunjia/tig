package com.zhirunjia.housekeeper.Utils;

import android.app.ActivityManager;
import android.content.Context;

/**
 * Created by Xu wenQiang on 14-6-26.
 */
public class ActivityUtil {

    /**
     * 获取当前活动的Activity名称
     * 需要设置权限: <uses-permission android:name="android.permission.GET_TASKS" />
     *
     * @param context
     * @return 当前运行的activity名称
     */
    public static String getRunningActivityName(Context context){
        ActivityManager activityManager=(ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        String runningActivity=activityManager.getRunningTasks(1).get(0).topActivity.getClassName();
        return runningActivity;
    }


    public static String getRunningActivityNameByContext(Context context){
        String contextString = context.toString();
        return contextString.substring(contextString.lastIndexOf(".")+1, contextString.indexOf("@"));
    }
}
