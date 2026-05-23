package com.example.RESTusingSpringboot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @RequestMapping("/")
    public  String greet(){
        return "welcome to the home page";
    }
}
