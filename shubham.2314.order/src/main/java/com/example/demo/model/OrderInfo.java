package com.example.demo.model;

import com.sun.javafx.beans.IDProperty;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@ToString
@Document(collection = "order")
public class OrderInfo {
    @Id
    private String orderId;
    private String customerId;
    private String orderTime;
    private ArrayList<OrderLineItem> orderLineItem;
    private long totalPrice;

    public OrderInfo() {
    }

    public OrderInfo(String orderId, String customerId, String orderTime, ArrayList<OrderLineItem> orderLineItem, long totalPrice) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.orderTime = orderTime;
        this.orderLineItem = orderLineItem;
        this.totalPrice = totalPrice;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public ArrayList<OrderLineItem> getOrderLineItem() {
        return orderLineItem;
    }

    public void setOrderLineItem(ArrayList<OrderLineItem> orderLineItem) {
        this.orderLineItem = orderLineItem;
    }

    public long getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(long totalPrice) {
        this.totalPrice = totalPrice;
    }
}
