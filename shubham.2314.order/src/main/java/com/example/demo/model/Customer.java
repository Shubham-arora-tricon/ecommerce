package com.example.demo.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@ToString
@Document(collection = "customer")
public class Customer {
    @Id
    private String customerId;
    private String customerName;
    private String emailId;
    private int phoneNo;
    private ArrayList<AddressModel> address;

    public Customer() {
    }

    public Customer(String customerId, String customerName, String emailId, int phoneNo, ArrayList<AddressModel> address) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.emailId = emailId;
        this.phoneNo = phoneNo;
        this.address = address;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public int getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(int phoneNo) {
        this.phoneNo = phoneNo;
    }

    public ArrayList<AddressModel> getAddress() {
        return address;
    }

    public void setAddress(ArrayList<AddressModel> address) {
        this.address = address;
    }
}
