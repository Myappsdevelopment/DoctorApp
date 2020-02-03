package com.mad.grubx.Model;

import java.io.Serializable;

public class DataModel2 implements Serializable {

    String prd_name;
    String prd_prize;
    String quantity;
    String places_on;
    String payment;
    String Duration;
    String ord_no;
    String expected_delivery;
    String status;
    int img;

    public DataModel2(String prd_name, String prd_prize, String quantity, String places_on, String payment, String duration, String ord_no, String expected_delivery, String status, int img) {
        this.prd_name = prd_name;
        this.prd_prize = prd_prize;
        this.quantity = quantity;
        this.places_on = places_on;
        this.payment = payment;
        Duration = duration;
        this.ord_no = ord_no;
        this.expected_delivery = expected_delivery;
        this.status = status;
        this.img = img;
    }


    public String getPrd_name() {
        return prd_name;
    }

    public void setPrd_name(String prd_name) {
        this.prd_name = prd_name;
    }

    public String getPrd_prize() {
        return prd_prize;
    }

    public void setPrd_prize(String prd_prize) {
        this.prd_prize = prd_prize;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getPlaces_on() {
        return places_on;
    }

    public void setPlaces_on(String places_on) {
        this.places_on = places_on;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public String getDuration() {
        return Duration;
    }

    public void setDuration(String duration) {
        Duration = duration;
    }

    public String getOrd_no() {
        return ord_no;
    }

    public void setOrd_no(String ord_no) {
        this.ord_no = ord_no;
    }

    public String getExpected_delivery() {
        return expected_delivery;
    }

    public void setExpected_delivery(String expected_delivery) {
        this.expected_delivery = expected_delivery;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
