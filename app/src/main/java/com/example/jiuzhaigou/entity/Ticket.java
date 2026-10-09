package com.example.jiuzhaigou.entity;

public class Ticket {
    private int id;
    private String type;
    private double price;
    private String useDate;
    private String timeSlot;
    private int remain;

    public Ticket(){}
    public Ticket(int id,String type,double price,String useDate,String timeSlot,int remain){
        this.id=id;
        this.type=type;
        this.price=price;
        this.useDate=useDate;
        this.timeSlot=timeSlot;
        this.remain=remain;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    public String getUseDate() { return useDate; }
    public void setUseDate(String useDate) { this.useDate = useDate; }
    public String getTimeSlot() { return timeSlot; }
    public void setTimeSlot(String timeSlot) { this.timeSlot = timeSlot; }
    public int getRemain() { return remain; }
    public void setRemain(int remain) { this.remain = remain; }
}