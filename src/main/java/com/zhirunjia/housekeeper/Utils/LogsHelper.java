package com.zhirunjia.housekeeper.Utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.zhirunjia.housekeeper.Dao.impl.LogsDao;
import com.zhirunjia.housekeeper.Domain.Object.Logs;

/**
 * 日志工具类
 * Created by Xu wenQiang on 2014/6/18.
 */
public class LogsHelper {

    private static LogsDao logsDao;

    private static DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void init(LogsDao dao) {
        logsDao = dao;
    }

    /**
     * 记录日志
     *
     * @param className 类名
     * @param level     级别
     * @param context   内容
     */
    public static void writeLogs(String className, String level, String context) {
        Logs logs = new Logs();
        logs.setClassName(className);
        logs.setLevel(level);
        logs.setContent(context);
        logs.setCreateTime(df.format(new Date()));
        logsDao.insert(logs);
    }

    /**
     * 记录INFO级别日志
     *
     * @param className 类名
     * @param context   内容
     */
    public static void writeInfoLogs(String className, String context) {
        writeLogs(className, "INFO", context);
    }

    /**
     * 记录ERROR级别日志
     *
     * @param className 类名
     * @param context   内容
     */
    public static void writeErrorLogs(String className, String context) {
        writeLogs(className, "ERROR", context);
    }

    /**
     * 记录DEBUG级别日志
     *
     * @param className 类名
     * @param context   内容
     */
    public static void writeDebugLogs(String className, String context) {
        writeLogs(className, "DEBUG", context);
    }

    /**
     * 记录WARN级别日志
     *
     * @param className 类名
     * @param context   内容
     */
    public static void writeWarnLogs(String className, String context) {
        writeLogs(className, "WARN", context);
    }
}
