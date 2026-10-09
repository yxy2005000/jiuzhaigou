package com.example.jiuzhaigou.entity;

import java.io.Serializable;
import java.util.List;

public class SubSpot implements Serializable {
    private String name;
    private String desc;
    private int imgRes;
    private List<Comment> commentList;

    // 构造方法
    public SubSpot(String name, String desc, int imgRes, List<Comment> commentList) {
        this.name = name;
        this.desc = desc;
        this.imgRes = imgRes;
        this.commentList = commentList;
    }

    // get 方法
    public String getName() { return name; }
    public String getDesc() { return desc; }
    public int getImgRes() { return imgRes; }
    public List<Comment> getCommentList() { return commentList; }
}