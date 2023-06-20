package com.example.domain;

import java.util.Date;

public class Fellow {
    private Integer id;
    private String fellow_name;
    private String fellow_phone;
    private String fellow_sex;
    private Date fellow_date;

    @Override
    public String toString() {
        return "Fellow{" +
                "id=" + id +
                ", fellow_name='" + fellow_name + '\'' +
                ", fellow_phone='" + fellow_phone + '\'' +
                ", fellow_sex='" + fellow_sex + '\'' +
                ", fellow_date=" + fellow_date +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFellow_name() {
        return fellow_name;
    }

    public void setFellow_name(String fellow_name) {
        this.fellow_name = fellow_name;
    }

    public String getFellow_phone() {
        return fellow_phone;
    }

    public void setFellow_phone(String fellow_phone) {
        this.fellow_phone = fellow_phone;
    }

    public String getFellow_sex() {
        return fellow_sex;
    }

    public void setFellow_sex(String fellow_sex) {
        this.fellow_sex = fellow_sex;
    }

    public Date getFellow_date() {
        return fellow_date;
    }

    public void setFellow_date(Date fellow_date) {
        this.fellow_date = fellow_date;
    }
}
