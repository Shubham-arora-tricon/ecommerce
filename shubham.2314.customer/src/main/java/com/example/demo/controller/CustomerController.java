package com.example.demo.controller;

import com.example.demo.model.Customer;
import com.example.demo.service.CustomerServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/customer")
public class CustomerController {

    private static final Logger log = LoggerFactory.getLogger(CustomerController.class.getName());

    @Autowired
    private CustomerServiceImpl csi;

    @GetMapping
    @ResponseBody
    public List<Customer> getAllCustomers(){
        log.info("Fetching List of customers started... in controller");
        return csi.getListOfCustomer();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Optional<Customer> getCustomerById(@PathVariable("id") String id){
        log.info("Fetching customers by id {} started... in controller",id);
        return csi.getCustomerById(id);
    }

    @PostMapping("/add")
    public void addCustomer(@RequestBody Customer c){
        log.info("saving the data started with value {}",c);
        csi.addCustomer(c);
    }
}
