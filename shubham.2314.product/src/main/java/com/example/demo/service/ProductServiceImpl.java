package com.example.demo.service;

import com.example.demo.dao.ProductRepository;
import com.example.demo.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository pr;

    @Override
    @Transactional(readOnly = true)
    public List<Product> getListOfProducts() {
        List<Product> listOfProduct = pr.findAll();
        return listOfProduct;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Product> getProductById(String id) {
        Optional<Product> product = pr.findById(id);
        return product;
    }
}
