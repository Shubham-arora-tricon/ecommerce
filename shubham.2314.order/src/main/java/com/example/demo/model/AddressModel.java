package com.example.demo.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
class AddressModel {
    private String street1;
    private String street2;
    private String city;
    private String state;
    private String country;
    private int pinCode;
}
