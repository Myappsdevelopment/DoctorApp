package com.mad.grubx.Model;

import java.io.Serializable;

public class DataModel1 implements Serializable {
    private int image;
    private String products_cnt;
    private String prd_name;

    public DataModel1(int image, String products_cnt, String prd_name) {
        this.image = image;
        this.products_cnt = products_cnt;
        this.prd_name = prd_name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getProducts_cnt() {
        return products_cnt;
    }

    public void setProducts_cnt(String products_cnt) {
        this.products_cnt = products_cnt;
    }

    public String getPrd_name() {
        return prd_name;
    }

    public void setPrd_name(String prd_name) {
        this.prd_name = prd_name;
    }
}
