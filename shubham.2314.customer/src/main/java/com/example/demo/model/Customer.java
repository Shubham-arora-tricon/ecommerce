package com.example.demo.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document(collection = "customer")
public class Customer {
    @Id
    private String customerId;
    private String customerName;
    private String emailId;
    private int phoneNo;
    private ArrayList<AddressModel> address;
}
