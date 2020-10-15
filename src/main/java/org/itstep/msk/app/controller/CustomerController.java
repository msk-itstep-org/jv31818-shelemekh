package org.itstep.msk.app.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.jni.Error;
import org.itstep.msk.app.entity.Customer;
import org.itstep.msk.app.entity.Product;
import org.itstep.msk.app.repository.CustomRepository;
import org.itstep.msk.app.service.ServiceCustomImp;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
//import reactor.core.publisher.Flux;
//import reactor.core.publisher.Mono;

import javax.jws.WebParam;
import javax.validation.Valid;
import java.awt.*;
import java.util.List;
import java.util.Optional;



@Slf4j
@Controller
public class CustomerController {

    private  ServiceCustomImp customImp;
    private  CustomRepository repo;

    @Autowired
    public CustomerController() {
        this.customImp = customImp;
        this.repo= repo;
    }

    @GetMapping(value = "/register")
    @ResponseStatus(HttpStatus.OK)
    private String register(
            @RequestParam(value = "name",required = false) String name,
           @RequestParam(value = "password", required = false) String password,
           @RequestParam(value = "email", required = false) String email
           ,@ModelAttribute Customer customer){
         return "register";

    }



/*
    Save in db customer with cridetials name , password
    return view "registersuccess"
 */
    @PostMapping( "/register")
    public @ResponseBody  String  succesreg(@ModelAttribute("name") String name, @ModelAttribute("password") String password,
                            @ModelAttribute("email") String email,Customer customer ){
        customer.setName(name);
        customer.setPassword(password);
        customer.setEmail(email);
        customImp.saveinDb(customer);
      return "/registersuccess";
    }


    @GetMapping("/listproduct")
    public List<Customer> productList( @RequestBody Product product,@RequestParam (value = "name_product", required = false)
            String name,
    @RequestParam(value = "final_price",required = false) Double price,Model model){
        model.addAttribute("product", product);
        return customImp.findAllCustomerofProduct();


    }
    @PreAuthorize("ROLE_USER")
    @DeleteMapping("/delete")
    public void deleteCustomerof(@RequestBody Customer customer){
        customImp.deleteCustomer();

    }












    }

