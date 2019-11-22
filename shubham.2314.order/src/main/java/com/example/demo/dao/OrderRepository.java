package com.example.demo.dao;

import com.example.demo.model.OrderInfo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends MongoRepository<OrderInfo, String> {
}
