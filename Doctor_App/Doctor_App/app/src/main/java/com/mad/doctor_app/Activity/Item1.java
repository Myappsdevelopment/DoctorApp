package com.mad.doctor_app.Activity;

public class Item1 {

    String name;
    int icon;
    String address;
    String ratings;
    String status;

    public Item1(String name, int icons, String address, String ratings,String status) {
        this.name = name;
        this.icon = icons;
        this.address = address;
        this.ratings = ratings;
        this.status=status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRatings() {
        return ratings;
    }

    public void setRatings(String ratings) {
        this.ratings = ratings;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}



