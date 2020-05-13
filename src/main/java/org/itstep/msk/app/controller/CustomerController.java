package org.itstep.msk.app.controller;

import org.itstep.msk.app.entity.Customer;
import org.itstep.msk.app.service.ReactCustomServImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@RestController
@RequestMapping(value = "/customer", produces ="application/json")
public class CustomerController {

    @Autowired
    private ReactiveCrudRepository reactiveCrudRepository;

    @Autowired
    private ReactCustomServImplement reactservice;

    @GetMapping("/register")
    private String register(){
        return "register";
    }

    @PostMapping(value = "/register",consumes = "application/json")
    public Mono<Customer> succesregister(Customer customer){
        return reactservice.addOne(customer);


    }

    @GetMapping("/listproduct")
    public  Flux<Customer> listProducts(){
        return  reactservice.allCustomer()
                .filter(customer -> customer.getId()==
                        customer.getProduct().getTotalPrice());












    }
}
