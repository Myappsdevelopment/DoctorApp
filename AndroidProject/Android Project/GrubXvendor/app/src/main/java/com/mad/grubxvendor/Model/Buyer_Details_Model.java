package com.mad.grubxvendor.Model;

import java.io.Serializable;

public class Buyer_Details_Model implements Serializable {

    int img;
    String person_name;
    String mart_name;


    public Buyer_Details_Model(int img, String person_name, String mart_name) {
        this.img = img;
        this.person_name = person_name;
        this.mart_name = mart_name;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getPerson_name() {
        return person_name;
    }

    public void setPerson_name(String person_name) {
        this.person_name = person_name;
    }

    public String getMart_name() {
        return mart_name;
    }

    public void setMart_name(String mart_name) {
        this.mart_name = mart_name;
    }
}
