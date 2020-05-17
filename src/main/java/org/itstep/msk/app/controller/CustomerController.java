package org.itstep.msk.app.controller;

import org.itstep.msk.app.entity.Customer;
import org.itstep.msk.app.entity.Product;
import org.itstep.msk.app.repository.CustomRepository;
import org.itstep.msk.app.service.ServiceCustomImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.awt.*;

@RestController
@RequestMapping(value = "/customer")
public class CustomerController {


    private ServiceCustomImp customImp;

    @Autowired
    public CustomerController( ServiceCustomImp customImp) {

        this.customImp = customImp;
    }

    @GetMapping("/register")
    private String register(){
        return "register";
    }

    @PostMapping(value = "/register{id}")
    public  void  succesregister(@RequestBody Customer customer, @PathVariable Integer id){
        customImp.findCustomerOnId();



    }

    @GetMapping("/listproduct")
    public String productList(@RequestBody Customer customer){
        return String.valueOf(customImp.findAllCustomerofProduct());

    }

    @DeleteMapping("/delete")
    public void deleteCustomerof(@RequestBody Customer customer){
        customImp.deleteCustomer();

    }












    }

