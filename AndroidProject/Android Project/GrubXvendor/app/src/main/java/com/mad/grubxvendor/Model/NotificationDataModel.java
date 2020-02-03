package com.mad.grubxvendor.Model;

import java.io.Serializable;

public class NotificationDataModel implements Serializable {

    private int image;
    private String name;
    private String time;

    public NotificationDataModel(int image, String name, String time) {
        this.image = image;
        this.name = name;
        this.time = time;
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
