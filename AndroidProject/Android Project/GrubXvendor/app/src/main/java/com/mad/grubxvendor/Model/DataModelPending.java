package com.mad.grubxvendor.Model;

import java.io.Serializable;

public class DataModelPending implements Serializable {

    String prd_name;
    String prd_prize;
    String quantity;
    String order_data;
    String payment;
    String Discount_code;
    String ord_no;
    String Delivery_location;
    String item_name;
    int img;

    public DataModelPending(String prd_name, String prd_prize, String quantity, String Orderdate, String payment, String discountcode, String ord_no, String deliverylocation, String itemname, int img) {
        this.prd_name = prd_name;
        this.prd_prize = prd_prize;
        this.quantity = quantity;
        this.order_data = Orderdate;
        this.payment = payment;
        Discount_code = discountcode;
        this.ord_no = ord_no;
        this.Delivery_location = deliverylocation;
        this.item_name = itemname;
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
        return order_data;
    }

    public void setPlaces_on(String places_on) {
        this.order_data = places_on;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public String getDuration() {
        return Discount_code;
    }

    public void setDuration(String duration) {
        Discount_code = duration;
    }

    public String getOrd_no() {
        return ord_no;
    }

    public void setOrd_no(String ord_no) {
        this.ord_no = ord_no;
    }

    public String getExpected_delivery() {
        return Delivery_location;
    }

    public void setExpected_delivery(String expected_delivery) {
        this.Delivery_location = expected_delivery;
    }

    public String getStatus() {
        return item_name;
    }

    public void setStatus(String status) {
        this.item_name = status;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}

