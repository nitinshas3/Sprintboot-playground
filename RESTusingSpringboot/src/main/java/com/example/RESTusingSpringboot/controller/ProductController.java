package com.example.RESTusingSpringboot.controller;

import com.example.RESTusingSpringboot.model.Product;
import com.example.RESTusingSpringboot.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    ProductService service;

    @RequestMapping("/products")
    public List<Product> getProducts(){
        return service.getProducts();
    }

    @RequestMapping("/products/{prodid}")
    public Product getproductybid(@PathVariable int prodid){
        return service.getproductbyid(prodid);
    }

    @PostMapping("/product")
    public void saveProduct(@RequestBody Product prd){
        service.saveProduct(prd);
    }

    @PutMapping("/product")
    public void updateProduct(@RequestBody Product prd){
        service.updateProduct(prd);
    }

}
