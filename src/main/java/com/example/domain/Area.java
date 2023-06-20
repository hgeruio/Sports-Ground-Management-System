package com.example.domain;

public class Area {
    private Integer id;
    private String area_name;
    private String area_range;

    public String getArea_range() {
        return area_range;
    }

    public void setArea_range(String area_range) {
        this.area_range = area_range;
    }

    private Integer number;
    private double money;

    @Override
    public String toString() {
        return "Area{" +
                "id=" + id +
                ", area_name='" + area_name + '\'' +
                ", area_range='" + area_range + '\'' +
                ", number=" + number +
                ", money=" + money +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getArea_name() {
        return area_name;
    }

    public void setArea_name(String area_name) {
        this.area_name = area_name;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
}
