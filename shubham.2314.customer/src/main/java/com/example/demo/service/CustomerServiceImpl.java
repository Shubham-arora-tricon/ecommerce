package com.example.demo.service;

import com.example.demo.dao.CustomerRepository;
import com.example.demo.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerRepository cr;

    @Override
    @Transactional(readOnly = true)
    public List<Customer> getListOfCustomer() {
        final List<Customer> listOfCustomer = cr.findAll();
        return listOfCustomer;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Customer> getCustomerById(String id) {
        final Optional<Customer> customerById = cr.findById(id);
        return customerById;
    }

    @Override
    @Transactional
    public void addCustomer(Customer c) {
        cr.save(c);
    }
}
