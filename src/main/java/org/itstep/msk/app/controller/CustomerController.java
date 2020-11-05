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



@Controller
@RequestMapping("/customers")
public class CustomerController {

    private  ServiceCustomImp customImp;
   private  CustomRepository repo;

    @Autowired
    public CustomerController() {
        this.customImp = customImp;
        this.repo= repo;
    }

    @GetMapping(value = "/register")
    private String register(Model model){
        model.addAttribute("customer",new Customer());
               return "register";

    }
    @GetMapping
    public String fromAll(Model model){
        Iterable<Customer> iterator= repo.findAll();
        model.addAttribute("iterator",iterator);
        return "redirect:/";

    }



/*
    Save in db customer with cridetials name , password
    return view "registersuccess"
 */
    @PostMapping
    public   String  succesreg(@RequestParam String name, @RequestParam String password,
                               @RequestParam String email, Model model){
        Customer cust= new Customer(name,password,email);
        model.addAttribute("cust",cust);
        customImp.saveinDb(cust);

      return "redirect:/registersuccess";
    }


    @GetMapping("/listproduct")
    public String productList( @RequestBody Product product,@RequestParam (value = "name_product", required = false)
            String name,
    @RequestParam(value = "final_price",required = false) Double price,Model model){
        model.addAttribute("product" , new Product());
        return "listproduct";


    }

    @PostMapping("/listorders")
    public Iterable<Customer> allProductWithPrice(@RequestBody Product product){
        return customImp.findAllCustomerofProduct();
    }



    @PreAuthorize("ROLE_USER")
    @DeleteMapping("/delete")
    public void deleteCustomerof(@RequestBody Customer customer){
        customImp.deleteCustomer();

    }












    }

