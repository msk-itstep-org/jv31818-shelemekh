package org.itstep.msk.app.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.jni.Error;
import org.itstep.msk.app.entity.Customer;
import org.itstep.msk.app.entity.Product;
import org.itstep.msk.app.repository.CustomRepository;
import org.itstep.msk.app.service.ServiceCustomImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.awt.*;
import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/customer")
public class CustomerController {


    private ServiceCustomImp customImp;

    @Autowired
    public CustomerController() {
        this.customImp = customImp;
    }

    @GetMapping("/register")
    private String register(Model model){
        model.addAttribute("register", new Customer());
        return "register";
    }




    @PostMapping(value = "/register")
    public  void  succesregister(@RequestBody Customer customer, @PathVariable Integer id){
        customImp.findCustomerOnId();



    }

    @GetMapping("/listproduct")
    public List<Customer> productList(@RequestBody Customer customer, Model model){
         customImp.findAllCustomerofProduct();
         return (List<Customer>) model.addAttribute(customer);

    }

    @DeleteMapping("/delete")
    public void deleteCustomerof(@RequestBody Customer customer){
        customImp.deleteCustomer();

    }












    }

