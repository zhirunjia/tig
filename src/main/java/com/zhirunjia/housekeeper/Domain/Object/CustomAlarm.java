package com.zhirunjia.housekeeper.Domain.Object;

import android.app.AlarmManager;
import android.content.Intent;

/**
 * 自定议闹钟
 * Created by WangYang on 2014/7/2.
 */
public class CustomAlarm {

    public static enum AlarmType {
        SERVICE, BROADCAST;
    }

    private AlarmType alarmType;
    private Class className;
    private String action;
    private int seconds;
    private int type = AlarmManager.RTC_WAKEUP;
    private int flag = Intent.FLAG_ACTIVITY_NEW_TASK;

    public CustomAlarm() {
    }

    public CustomAlarm(AlarmType alarmType, Class className, int seconds) {
        this.alarmType = alarmType;
        this.className = className;
        this.seconds = seconds;
    }

    public CustomAlarm(AlarmType alarmType, Class className, int seconds, String action) {
        this.alarmType = alarmType;
        this.className = className;
        this.seconds = seconds;
        this.action = action;
    }

    public AlarmType getAlarmType() {
        return alarmType;
    }

    public void setAlarmType(AlarmType alarmType) {
        this.alarmType = alarmType;
    }

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    public Class getClassName() {
        return className;
    }

    public void setClassName(Class className) {
        this.className = className;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }
}
