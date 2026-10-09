package com.example.jiuzhaigou.entity;

public class User {
    private int id;
    private String nickname;
    private String name;
    private String gender;
    private String phone;
    private String job;
    private String hobby;
    private String password;

    // 无参、有参、get/set
    public User(){}
    public User(int id,String nickname,String name,String gender,String phone,String job,String hobby,String password){
        this.id=id;
        this.nickname=nickname;
        this.name=name;
        this.gender=gender;
        this.phone=phone;
        this.job=job;
        this.hobby=hobby;
        this.password=password;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNickname() { return nickname; }
    public void setNickname(String nickname) { this.nickname = nickname; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public String getJob() { return job; }
    public void setJob(String job) { this.job = job; }
    public String getHobby() { return hobby; }
    public void setHobby(String hobby) { this.hobby = hobby; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}