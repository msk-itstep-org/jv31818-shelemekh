package org.itstep.msk.app.controller;

import org.itstep.msk.app.entity.Customer;
import org.itstep.msk.app.entity.Product;
import org.itstep.msk.app.repository.ProductRepository;
import org.itstep.msk.app.service.ServiceCustomImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/register")
    public String succesregister(@RequestBody Customer customer, Model model){
        model.addAttribute(new Customer());

        return new Customer().toString();
    }

    @GetMapping("/listproduct")
    public String listProducts(){
        List<Product> productList = productRepository.findAll();

        return "listproduct";

    }
}
