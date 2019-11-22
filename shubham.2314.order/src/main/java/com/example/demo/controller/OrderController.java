package com.example.demo.controller;

import com.example.demo.model.OrderInfo;
import com.example.demo.model.OrderInfoPerCustomer;
import com.example.demo.service.OrderServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/v1/order")
public class OrderController {

    private static final Logger log = LoggerFactory.getLogger(OrderController.class.getName());

    @Autowired
    private OrderServiceImpl osi;

    @RequestMapping(method=RequestMethod.POST)
    public void addOrderInfo(@RequestBody OrderInfo op){
        log.info("Order is adding with value {}",op);
        osi.addOrder(op);
        log.info("Order is adding with value {}",op);
    }

    @GetMapping("/orders")
    public OrderInfoPerCustomer getListOfOrderBy(@RequestParam String id){
        return osi.getOrderById(id);
    }

}
