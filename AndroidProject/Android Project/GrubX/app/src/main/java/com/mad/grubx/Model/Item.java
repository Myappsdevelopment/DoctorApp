package com.mad.grubx.Model;

import java.io.Serializable;

public class Item implements Serializable {
    int image;
    String name;
    String prd_count;

    public Item(int image, String name, String prd_count) {
        this.image = image;
        this.name = name;
        this.prd_count = prd_count;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrd_count() {
        return prd_count;
    }

    public void setPrd_count(String prd_count) {
        this.prd_count = prd_count;
    }
}
