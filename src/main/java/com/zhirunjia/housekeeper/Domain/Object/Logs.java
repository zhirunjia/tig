package com.zhirunjia.housekeeper.Domain.Object;

/**
 * 日志表
 * Created by WangYang on 2014/6/18.
 */
public class Logs {

    //日志ID
    private Long id;
    // 输出类名
    private String className;
    // 日志等级
    private String level;
    // 日志内容
    private String content;
    // 建立时间
    private String createTime;
    // 同步时间
    private String synchronizationTime;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getSynchronizationTime() {
        return synchronizationTime;
    }

    public void setSynchronizationTime(String synchronizationTime) {
        this.synchronizationTime = synchronizationTime;
    }
}
