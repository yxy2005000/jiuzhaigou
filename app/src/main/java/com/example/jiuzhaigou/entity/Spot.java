package com.example.jiuzhaigou.entity;

import java.util.List;

public class Spot {
    private String name;
    private String desc;
    private int coverImgRes;
    private List<SubSpot> subSpots;

    public Spot(String name, String desc, int coverImgRes, List<SubSpot> subSpots) {
        this.name = name;
        this.desc = desc;
        this.coverImgRes = coverImgRes;
        this.subSpots = subSpots;
    }

    public String getName() { return name; }
    public String getDesc() { return desc; }
    public int getCoverImgRes() { return coverImgRes; }
    public List<SubSpot> getSubSpots() { return subSpots; }
}