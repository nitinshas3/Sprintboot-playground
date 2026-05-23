package com.example.RESTusingSpringboot.model;

public class Product {
    int pid;
    String pname;
    int price;

    public Product() {

    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getPid() {
        return pid;
    }

    public String getPname() {
        return pname;
    }

    public int getPrice() {
        return price;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Product(int pid, String pname, int price) {
        this.pid = pid;
        this.pname = pname;
        this.price = price;
    }
}
