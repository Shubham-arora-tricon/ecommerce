package com.example.demo.model;

import lombok.ToString;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@ToString
@Component
public class OrderInfoPerCustomer {
    private Customer customer;
    private ArrayList<Product> orderLineItems;
    private long totalPrice;

    public OrderInfoPerCustomer(Customer customer, ArrayList<Product> orderLineItems, long totalPrice) {
        this.customer = customer;
        this.orderLineItems = orderLineItems;
        this.totalPrice = totalPrice;
    }

    public OrderInfoPerCustomer() {
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public ArrayList<Product> getOrderLineItems() {
        return orderLineItems;
    }

    public void setOrderLineItems(ArrayList<Product> orderLineItems) {
        this.orderLineItems = orderLineItems;
    }

    public long getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(long totalPrice) {
        this.totalPrice = totalPrice;
    }

}
