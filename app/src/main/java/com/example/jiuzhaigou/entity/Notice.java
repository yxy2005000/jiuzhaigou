package com.example.jiuzhaigou.entity;

public class Notice {
    private int id;
    private String title;
    private String content;
    private String date;
    private String author; // 新增
    private String type;   // 新增

    // 空构造（保留）
    public Notice() {}

    // 原来的 3参构造（保留，兼容旧代码）
    public Notice(String title, String content, String date) {
        this.title = title;
        this.content = content;
        this.date = date;
    }

    // 新增：6参构造（适配你的公告数据）
    public Notice(String title, String content, String date, String author, String type) {
        this.title = title;
        this.content = content;
        this.date = date;
        this.author = author;
        this.type = type;
    }

    // 原来的全参构造（保留）
    public Notice(int id, String title, String content, String imgUrl, String date) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.date = date;
    }

    // 新增字段的 getter/setter
    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    // 原来的 getter/setter 全部保留
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }
}