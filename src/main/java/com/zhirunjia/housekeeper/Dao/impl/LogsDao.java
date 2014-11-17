package com.zhirunjia.housekeeper.Dao.impl;

import java.util.ArrayList;
import java.util.List;

import android.database.Cursor;

import com.zhirunjia.housekeeper.Dao.DBOperate;
import com.zhirunjia.housekeeper.Domain.Object.Logs;
import com.zhirunjia.housekeeper.Utils.DBOpenHelper;
import com.zhirunjia.housekeeper.Utils.SqlHelper;

/**
 * 快递柜信息表
 * Created by WangYang on 2014/5/7.
 */
public class LogsDao implements DBOperate<Logs> {

    private DBOpenHelper dbOpenHelper;

    public LogsDao(DBOpenHelper dbOpenHelper) {
        this.dbOpenHelper = dbOpenHelper;
    }

    public List<Logs> queryByTime(String... params) {
        String querySql = "SELECT id,class_name,level,content,create_time,synchronization_time " +
                "FROM tb_logs " +
                "WHERE create_time >= ? " +
                "AND create_time <= ?";
        Cursor cursors = dbOpenHelper.getReadableDatabase().rawQuery(querySql, params);
        List<Logs> dataList = new ArrayList<Logs>();
        while (cursors.moveToNext()) {
            Logs log = new Logs();
            log.setId(cursors.getLong(cursors.getColumnIndex("id")));
            log.setClassName(cursors.getString(cursors.getColumnIndex("class_name")));
            log.setLevel(cursors.getString(cursors.getColumnIndex("level")));
            log.setContent(cursors.getString(cursors.getColumnIndex("content")));
            log.setCreateTime(cursors.getString(cursors.getColumnIndex("create_time")));
            log.setSynchronizationTime(cursors.getString(cursors.getColumnIndex("synchronization_time")));
            dataList.add(log);
        }
        return dataList;
    }

    @Override
    public List<Logs> query(Logs param) {
        List<String> params = new ArrayList<String>();
        String querySql = SqlHelper.createQuerySql(param, params);
        Cursor cursors = dbOpenHelper.getReadableDatabase().rawQuery(querySql, (String[]) params.toArray());
        List<Logs> dataList = new ArrayList<Logs>();
        while (cursors.moveToNext()) {
            Logs log = new Logs();
            log.setId(cursors.getLong(cursors.getColumnIndex("id")));
            log.setClassName(cursors.getString(cursors.getColumnIndex("class_name")));
            log.setLevel(cursors.getString(cursors.getColumnIndex("level")));
            log.setContent(cursors.getString(cursors.getColumnIndex("content")));
            log.setCreateTime(cursors.getString(cursors.getColumnIndex("create_time")));
            log.setSynchronizationTime(cursors.getString(cursors.getColumnIndex("synchronization_time")));
            dataList.add(log);
        }
        return dataList;
    }

    @Override
    public void insert(Logs param) {
        String insertSql = "INSERT INTO tb_logs(class_name,level,content,create_time) VALUES(?,?,?,?)";
        String[] args = new String[4];
        args[0] = param.getClassName();
        args[1] = param.getLevel();
        args[2] = param.getContent();
        args[3] = param.getCreateTime();
        dbOpenHelper.getWritableDatabase().execSQL(insertSql, args);
    }

    @Override
    public void update(Logs param) {
        List<Object> params = new ArrayList<Object>();
        String updateSql = SqlHelper.createUpdateSql(param, params, "id");
        dbOpenHelper.getWritableDatabase().execSQL(updateSql, params.toArray());
    }

    @Override
    public void delete(Logs param) {
        List<Object> params = new ArrayList<Object>();
        String deleteSql = SqlHelper.createDeleteSql(param, params);
        dbOpenHelper.getWritableDatabase().execSQL(deleteSql, params.toArray());
    }
}
