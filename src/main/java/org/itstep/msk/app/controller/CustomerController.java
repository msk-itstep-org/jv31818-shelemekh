package org.itstep.msk.app.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.jni.Error;
import org.itstep.msk.app.entity.Customer;
import org.itstep.msk.app.entity.Product;
import org.itstep.msk.app.repository.CustomRepository;
import org.itstep.msk.app.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
//import reactor.core.publisher.Flux;
//import reactor.core.publisher.Mono;

import javax.jws.WebParam;
import javax.validation.Valid;
import java.awt.*;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;


@Controller
@RequestMapping(value = "/")
public class CustomerController {


  private CustomRepository customRepository;
    private ProductRepository productRepository;

    @Autowired
    public CustomerController(CustomRepository customRepository, ProductRepository productRepository) {
        this.customRepository = customRepository;
        this.productRepository = productRepository;
    }


//Get from Customer credentials as name ,password
    @GetMapping("/register")
    private String register( @ModelAttribute Customer customer,@RequestParam(required = false) String name,
                             @RequestParam(required = false) String password,Model model){
        model.addAttribute("customer",customer);
        return "register";
    }


/*
    Save in db customer with cridetials name , password
    return view "registersuccess"
 */
    @PostMapping("/register")
    public   String  succesreg(@RequestParam String name,
                               @RequestParam String password,@RequestBody Customer custome,
                               Errors errors, ModelMap modelMap) {
        if (errors.hasErrors()) {
            return "register";
        } else {
            modelMap.put("name",name);
            modelMap.put("password",password);
            customRepository.save(custome);

            return "redirect:/registersuccess";
        }
    }


        @GetMapping("/listproduct")
        public String productList (@RequestBody Product product, @RequestParam(value = "name_product", required = false) String name,
                @RequestParam(value = "final_price", required = false) Double price, Model model){
            model.addAttribute("product", product);
            return "listproduct";


        }
        @GetMapping("/listproduct/{id}")
        public ResponseEntity<Product> getCurrentProduct (@PathVariable Integer id){
            Optional<Product> optionalProduct = productRepository.findById(id);
            if (optionalProduct.isPresent())
                return ResponseEntity.ok(optionalProduct.get());
            return ResponseEntity.notFound().build();
        }

        @PostMapping("/listorders")
        public Iterable<Product> allProductWithPrice (@RequestBody Product product){
            return productRepository.findAll();
        }


        @PreAuthorize("ROLE_USER")
        @DeleteMapping("/delete/{id}")
        public void deleteCustomerof (@PathVariable Integer id, @RequestBody Customer customer){
            customRepository.delete(customer);

        }

    }














