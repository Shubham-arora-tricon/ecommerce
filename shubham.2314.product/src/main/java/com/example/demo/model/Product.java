package com.example.demo.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document(collection = "product")
public class Product {
    @Id
    private String productId;
    private String productName;
    private String description;
    private int unitPrice;
    private String currency;
}
