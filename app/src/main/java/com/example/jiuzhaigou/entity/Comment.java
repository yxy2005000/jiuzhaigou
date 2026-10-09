package com.example.jiuzhaigou.entity;

import java.io.Serializable;
public class Comment implements Serializable {
    // 注意这里的变量名要和getter对应
    private String userName;
    private String content;
    private String time;

    // 构造方法
    public Comment(String userName, String content, String time) {
        this.userName = userName;
        this.content = content;
        this.time = time;
    }

    // 必须有这三个getter方法
    public String getUserName() {
        return userName;
    }

    public String getContent() {
        return content;
    }

    public String getTime() {
        return time;
    }
}