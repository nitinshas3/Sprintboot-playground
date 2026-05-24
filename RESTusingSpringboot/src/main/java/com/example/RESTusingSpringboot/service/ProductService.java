package com.example.RESTusingSpringboot.service;

import com.example.RESTusingSpringboot.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {
    List<Product> products =  new ArrayList<>( Arrays.asList(
            new Product(101,"phone",100000),
            new Product(102,"laptop",50000)
    ));

    public List<Product>   getProducts(){
        return products;
    }
    public Product getproductbyid(int id){
        for(Product val: products){
            if(val.getPid() == id) return val;
        }
        return null;
    }

    public void saveProduct(Product prd){
        products.add(prd);
    }

    public void updateProduct(Product prd) {
        int pid = prd.getPid();
        for(Product val: products){
            if(pid==val.getPid()){
                val.setPname(prd.getPname());
                val.setPrice(prd.getPrice());
            }
        }
        //same for delete product
    }
}
