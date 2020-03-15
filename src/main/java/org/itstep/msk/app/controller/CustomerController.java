package org.itstep.msk.app.controller;

import org.itstep.msk.app.entity.Customer;
import org.itstep.msk.app.entity.Product;
import org.itstep.msk.app.repository.ProductRepository;
import org.itstep.msk.app.service.ServiceCustomImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

@RestController
@RequestMapping(value = "/customer", produces = "application/json")
public class CustomerController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ServiceCustomImp serviceCustomImp;

    @GetMapping("/register")
    private String register(){

        return "register";
    }

    @PostMapping(value = "/register{id}",consumes = "application/json")
    public Customer succesregister(@PathVariable Integer id){

       serviceCustomImp.findCustomerOnId();

        return new Customer();
    }

    @GetMapping("/listproduct")
    public String listProducts(){
        List<Product> productList = productRepository.findAll();

        return "listproduct";

    }
}
