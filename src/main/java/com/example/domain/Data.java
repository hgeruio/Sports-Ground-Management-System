package com.example.domain;

import java.util.Date;

public class Data {
    private Integer id;
    private String user;
    private String phone;
    private String area_name;
    private String fellow;
    private double money;
    private String time;
    private Date end_time;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    private  String status;

    @Override
    public String toString() {
        return "Data{" +
                "id=" + id +
                ", user='" + user + '\'' +
                ", phone='" + phone + '\'' +
                ", area_name='" + area_name + '\'' +
                ", fellow='" + fellow + '\'' +
                ", money=" + money +
                ", time='" + time + '\'' +
                ", end_time=" + end_time +
                ", status="+status+
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getArea_name() {
        return area_name;
    }

    public void setArea_name(String area_name) {
        this.area_name = area_name;
    }

    public String getFellow() {
        return fellow;
    }

    public void setFellow(String fellow) {
        this.fellow = fellow;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Date getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Date end_time) {
        this.end_time = end_time;
    }
}
