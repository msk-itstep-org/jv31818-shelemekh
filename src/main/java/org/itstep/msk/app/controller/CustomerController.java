package org.itstep.msk.app.controller;

import org.itstep.msk.app.entity.Customer;
import org.itstep.msk.app.entity.Product;
import org.itstep.msk.app.repository.ProductRepository;
import org.itstep.msk.app.service.ServiceCustomImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

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

    @GetMapping(value = "/listproduct", produces = "application/json")
    public List <Product> listProducts(){
     List<Product> productList = (List<Product>) productRepository.findAll().stream()
             .distinct();

         return productList;

    }

    @PutMapping(value = "/product{id}")
    public Optional<Product> update(@PathVariable("product_id") Integer id,
                                    @RequestBody Product product){

        return productRepository.findById(id).filter(product1 -> product.getTotalPrice()<1000);


    }
}
