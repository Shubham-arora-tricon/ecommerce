package com.example.demo.service;

import com.example.demo.model.OrderInfo;
import com.example.demo.model.OrderInfoPerCustomer;

public interface OrderService {
    public void addOrder(OrderInfo op);
    public OrderInfoPerCustomer getOrderById(String id);
}
