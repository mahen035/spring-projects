package com.ps.springboot.controller;

import com.ps.springboot.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController // @Controller + @ResponseBody
@RequestMapping("/")
public class HomeController {

    @GetMapping
    public List<Product> sayHi(){
        System.out.println("Inside Home controller");
        List<Product> productList = new ArrayList<>();
        productList.add(new Product(101,"Fridge","LG",500));
        productList.add(new Product(102,"TV","SONY",500));
        return productList;
    }
}
