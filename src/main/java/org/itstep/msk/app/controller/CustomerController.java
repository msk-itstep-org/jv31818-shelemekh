package org.itstep.msk.app.controller;

import org.itstep.msk.app.entity.Customer;
import org.itstep.msk.app.entity.Product;
import org.itstep.msk.app.repository.ProductRepository;
import org.itstep.msk.app.service.ServiceCustomImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/customer", produces = "application/json")

public class CustomerController {
	
	RestTemplate rest = new RestTemplate();
	
	
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ServiceCustomImp serviceCustomImp;

    @GetMapping("/register")
    private String register(){
        return "register";
    }

    @PostMapping(value = "/register", consumes = "application/json")
    public  Customer createCustomer(Customer customer) {
    	return rest.postForObject("http://localhost:8082/customer/register", customer, Customer.class);
    }

    @GetMapping("/listproduct")
    public Product listProducts(){
        List<Product> productList = (List<Product>) productRepository.findAll().stream()
                .distinct();


        return new Product();

    }
}
