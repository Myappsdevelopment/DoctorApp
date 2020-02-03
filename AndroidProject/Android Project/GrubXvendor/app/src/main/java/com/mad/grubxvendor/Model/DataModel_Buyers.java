package com.mad.grubxvendor.Model;

import java.io.Serializable;

public class DataModel_Buyers implements Serializable {

    int img;
    String name;
    String mart_name;
    String status;

    public DataModel_Buyers(int img, String name, String mart_name, String status) {
        this.img = img;
        this.name = name;
        this.mart_name = mart_name;
        this.status = status;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMart_name() {
        return mart_name;
    }

    public void setMart_name(String mart_name) {
        this.mart_name = mart_name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
