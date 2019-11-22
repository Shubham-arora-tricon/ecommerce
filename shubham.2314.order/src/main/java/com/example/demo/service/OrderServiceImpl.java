package com.example.demo.service;

import com.example.demo.dao.OrderRepository;
import com.example.demo.model.Customer;
import com.example.demo.model.OrderInfo;
import com.example.demo.model.OrderInfoPerCustomer;
import com.example.demo.model.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    private static final Logger log = LoggerFactory.getLogger(OrderService.class.getName());

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private OrderRepository or;

    @Autowired
    private OrderInfoPerCustomer oipc;

    @Override
    @Transactional
    public void addOrder(OrderInfo op) {
        log.info("Transaction for saving the data with value {} is started....",op);
        or.save(op);
        log.info("Transaction for saving the data with value {} is ended....",op);
    }

    @Override
    public OrderInfoPerCustomer getOrderById(String id) {
        final Optional<OrderInfo> orderInfoById = or.findById(id);
        final String customerId = orderInfoById.get().getCustomerId();
        final Customer customer = restTemplate.getForObject("http://customer/v1/customer/"+customerId, Customer.class);
        log.info("Customer is having the value {}",customer);
        oipc.setCustomer(customer);
        ArrayList<Product> orderLineItems=new ArrayList<Product>();
        final long[] totalPrice = {0};
        orderInfoById.get().getOrderLineItem().forEach(item -> {
            Product product = restTemplate.getForObject("http://product/v1/products?id="+item.getProductId(), Product.class);
            int unitPrice = product.getUnitPrice();
            int quantity = item.getQuantity();
            totalPrice[0] += unitPrice*quantity;
            orderLineItems.add(product);
        });
        oipc.setOrderLineItems(orderLineItems);
        log.info("OrderLineItems Array having value {} we are getting from product microservice",orderLineItems);
        oipc.setTotalPrice(totalPrice[0]);
        log.info("Total Price we are getting is {}",totalPrice);
        log.info("And finally we are returning the whole json schema which user is requested for the corresponding orderId {}",id);
        return oipc;
    }
}
