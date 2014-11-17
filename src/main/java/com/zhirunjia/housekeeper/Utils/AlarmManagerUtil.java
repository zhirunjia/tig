package com.zhirunjia.housekeeper.Utils;


import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;

import com.zhirunjia.housekeeper.Activity.HomeActivity;

/**
 * Created by Xu wenQiang on 14-7-2.
 */
public class AlarmManagerUtil {

    private Context context;
    private AlarmManager alarmManager;
    private PendingIntent pendingIntent;
    private String TAG = "AlarmManagerUtil";

    /**
     * 构造函数
     *
     * @param context
     */
    public AlarmManagerUtil(Context context){
        this.context = context;
        alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
    }

    /**
     *  倒计时跳转至系统首页
     *
     *
     */
    public void countDownForwardSystemFirstPage(){
        Intent intent = new Intent(context, HomeActivity.class);
        pendingIntent = PendingIntent.getService(context, 0, intent, 0);
        //alarmManager.cancel(pendingIntent);
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, SystemClock.elapsedRealtime(), 1000, pendingIntent);
    }

    /**
     * 取消定时任务
     *
     *
     */
    public void cancelCountDown(){
        alarmManager.cancel(pendingIntent);
    }

}
