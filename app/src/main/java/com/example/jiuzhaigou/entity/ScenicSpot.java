package com.example.jiuzhaigou.entity;

public class ScenicSpot {
    private int id;
    private String name;
    private String intro;
    private String imgUrl;
    private int parentId;

    public ScenicSpot(){}
    public ScenicSpot(int id,String name,String intro,String imgUrl,int parentId){
        this.id=id;
        this.name=name;
        this.intro=intro;
        this.imgUrl=imgUrl;
        this.parentId=parentId;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getIntro() { return intro; }
    public void setIntro(String intro) { this.intro = intro; }
    public String getImgUrl() { return imgUrl; }
    public void setImgUrl(String imgUrl) { this.imgUrl = imgUrl; }
    public int getParentId() { return parentId; }
    public void setParentId(int parentId) { this.parentId = parentId; }
}