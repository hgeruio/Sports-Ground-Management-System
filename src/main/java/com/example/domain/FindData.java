package com.example.domain;

public class FindData {
    private String user;
    private String area_name;

    @Override
    public String toString() {
        return "FindData{" +
                "user='" + user + '\'' +
                ", area_name='" + area_name + '\'' +
                '}';
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getArea_name() {
        return area_name;
    }

    public void setArea_name(String area_name) {
        this.area_name = area_name;
    }
}
