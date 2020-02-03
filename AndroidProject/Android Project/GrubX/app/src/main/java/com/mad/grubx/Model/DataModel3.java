package com.mad.grubx.Model;

public class DataModel3 {
    int img;
    String name;
    String hotel_name;

    public DataModel3(int img, String name, String hotel_name) {
        this.img = img;
        this.name = name;
        this.hotel_name = hotel_name;
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

    public String getHotel_name() {
        return hotel_name;
    }

    public void setHotel_name(String hotel_name) {
        this.hotel_name = hotel_name;
    }
}
