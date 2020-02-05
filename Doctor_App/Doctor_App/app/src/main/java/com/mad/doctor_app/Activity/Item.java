package com.mad.doctor_app.Activity;

public class Item {

    String name;
    int icons;

    public Item(String name, int icons) {
        this.name = name;
        this.icons = icons;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIcons() {
        return icons;
    }

    public void setIcons(int icons) {
        this.icons = icons;
    }
}

