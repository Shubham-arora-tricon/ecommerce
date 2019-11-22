package com.example.demo.service;

import com.example.demo.model.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    public List<Customer> getListOfCustomer();
    public Optional<Customer> getCustomerById(String id);
    public void addCustomer(Customer c);
}
