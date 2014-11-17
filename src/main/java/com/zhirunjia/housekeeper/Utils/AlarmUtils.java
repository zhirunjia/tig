package com.zhirunjia.housekeeper.Utils;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

import com.zhirunjia.housekeeper.Domain.Object.CustomAlarm;

/**
 * 闹钟工具类
 * Created by Xu wenQiang on 2014/7/2.
 */
public class AlarmUtils {

    /**
     * 开启闹钟后台服务
     *
     * @param context 上下文
     * @param alarm   闹钟任务
     */
    public static void startAlarm(Context context, CustomAlarm alarm) {
        //获取AlarmManager系统服务
        AlarmManager manager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        //包装需要执行Service的Intent
        Intent intent = new Intent(context, alarm.getClassName());
        if (alarm.getAction() != null && alarm.getAction().trim().length() > 0) {
            intent.setAction(alarm.getAction());
        }
        PendingIntent pendingIntent = null;
        switch (alarm.getAlarmType()) {
            case SERVICE:
                pendingIntent = PendingIntent.getService(context, 0, intent, alarm.getFlag());
                break;
            case BROADCAST:
                pendingIntent = PendingIntent.getBroadcast(context, 0, intent, alarm.getFlag());
                break;
        }
        //使用AlarmManger的setRepeating方法设置定期执行的时间间隔（seconds秒）和需要执行的Service
        manager.setInexactRepeating(alarm.getType(), System.currentTimeMillis() + alarm.getSeconds() * 1000, alarm.getSeconds() * 1000, pendingIntent);
    }

    /**
     * 停止闹钟后台服务
     *
     * @param context 上下文
     * @param alarm   闹钟任务
     */
    public static void stopAlarm(Context context, CustomAlarm alarm) {
        AlarmManager manager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(context, alarm.getClassName());
        if (alarm.getAction() != null && alarm.getAction().trim().length() > 0) {
            intent.setAction(alarm.getAction());
        }
        PendingIntent pendingIntent = null;
        switch (alarm.getAlarmType()) {
            case SERVICE:
                pendingIntent = PendingIntent.getService(context, 0, intent, alarm.getFlag());
                break;
            case BROADCAST:
                pendingIntent = PendingIntent.getBroadcast(context, 0, intent, alarm.getFlag());
                break;
        }
        //取消正在执行的服务
        manager.cancel(pendingIntent);
    }

}
