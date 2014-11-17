package com.zhirunjia.housekeeper.Utils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * 数据库操作工具类
 * Created by Xu wenQiang on 2014/3/20.
 */
public class DBOpenHelper extends SQLiteOpenHelper {

    public DBOpenHelper(Context context) {
        super(context, FileOpenHelper.DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        System.out.println("开始建立数据库.....");
        createDataBase(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public static void createDataBase(SQLiteDatabase db) {
        // 建立日志表
        db.execSQL(createLog());
    }

    private static String createLog() {
        StringBuilder sql = new StringBuilder();
        sql.append("CREATE TABLE tb_logs (");
        sql.append(" id INTEGER  PRIMARY KEY AUTOINCREMENT,");
        sql.append("class_name  TEXT NOT NULL,");
        sql.append("level  TEXT NOT NULL,");
        sql.append("content  TEXT NOT NULL,");
        sql.append("create_time  TEXT,");
        sql.append("synchronization_time  TEXT");
        sql.append(")");
        return sql.toString();
    }

}
