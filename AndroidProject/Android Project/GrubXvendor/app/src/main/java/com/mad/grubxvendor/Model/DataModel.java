package com.mad.grubxvendor.Model;

import java.io.Serializable;

public class DataModel implements Serializable {

    private int image;
    private String discount;
    private String prd_name;
    private String prd_amount;
    private String prd_strikeamount;

    public DataModel(int image, String discount, String prd_name, String prd_amount, String prd_strikeamount) {
        this.image = image;
        this.discount = discount;
        this.prd_name = prd_name;
        this.prd_amount = prd_amount;
        this.prd_strikeamount = prd_strikeamount;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getPrd_name() {
        return prd_name;
    }

    public void setPrd_name(String prd_name) {
        this.prd_name = prd_name;
    }

    public String getPrd_amount() {
        return prd_amount;
    }

    public void setPrd_amount(String prd_amount) {
        this.prd_amount = prd_amount;
    }

    public String getPrd_strikeamount() {
        return prd_strikeamount;
    }

    public void setPrd_strikeamount(String prd_strikeamount) {
        this.prd_strikeamount = prd_strikeamount;
    }
}

