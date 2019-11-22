package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.service.ProductServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1")
public class ProductController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductServiceImpl ps;

    @RequestMapping(value="/product", method = RequestMethod.GET)
    public List<Product> getAllProducts(){
        LOGGER.info("Fetching list of products");
        final List<Product> listOfProducts = ps.getListOfProducts();
        return listOfProducts;
    }

    @GetMapping("/products")
    @ResponseBody
    public  Optional<Product> getProductById(@RequestParam(required = true) String id){
        LOGGER.info("Fetching product by id having value {}",id);
        final Optional<Product> product = ps.getProductById(id);
        return product;
    }

}
