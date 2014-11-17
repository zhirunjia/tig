package com.zhirunjia.housekeeper.Dao;

import java.util.List;

/**
 * 数据库操作接口
 * Created by Xu wenQiang on 2014/5/7.
 */
public interface DBOperate<T> {

    /**
     * 根据条件查询结果
     * @param param 查询条件
     */
    public List<T> query(T param);

    /**
     * 插入新记录
     * @param param 对象
     */
    public void insert(T param);

    /**
     * 更新记录
     * @param param 对象
     */
    public void update(T param);

    /**
     * 删除记录
     * @param param 条件
     */
    public void delete(T param);

}
