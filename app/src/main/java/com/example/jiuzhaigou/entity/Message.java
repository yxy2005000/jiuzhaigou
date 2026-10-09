package com.example.jiuzhaigou.entity;

public class Message {
    private int id;
    private String content;
    private String username;
    private String time;
    private int spotId;

    public Message(){}
    public Message(int id,String content,String username,String time,int spotId){
        this.id=id;
        this.content=content;
        this.username=username;
        this.time=time;
        this.spotId=spotId;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getTime() { return time; }
    public void setTime(String time) { this.time = time; }
    public int getSpotId() { return spotId; }
    public void setSpotId(int spotId) { this.spotId = spotId; }
}