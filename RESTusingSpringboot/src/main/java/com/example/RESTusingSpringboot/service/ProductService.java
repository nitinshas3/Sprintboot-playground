package com.example.RESTusingSpringboot.service;

import com.example.RESTusingSpringboot.model.Product;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {
    List<Product> products = Arrays.asList(
            new Product(101,"phone",100000),
            new Product(102,"laptop",50000)
    );

    public List<Product>   getProducts(){
        return products;
    }
}
