package org.itstep.msk.app.controller;

import org.itstep.msk.app.entity.Customer;
import org.itstep.msk.app.entity.Product;
import org.itstep.msk.app.repository.ProductRepository;
import org.itstep.msk.app.service.ServiceCustomImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CustomerController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ServiceCustomImp serviceCustomImp;

    @GetMapping("/register")
    private String register(){
        return "register";
    }

    @PostMapping("/register{id}")
    public String succesregister(@PathVariable Integer id){

       serviceCustomImp.findCustomerOnId();

        return "register";
    }

    @GetMapping("/listproduct")
    public String listProducts(){
        List<Product> productList = productRepository.findAll();

        return "listproduct";

    }
}
