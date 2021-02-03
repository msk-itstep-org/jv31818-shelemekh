package org.itstep.msk.app.controller;

import org.itstep.msk.app.entity.Customer;
import org.itstep.msk.app.entity.Product;
import org.itstep.msk.app.repository.CustomRepository;
import org.itstep.msk.app.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

//import org.springframework.data.repository.reactive.ReactiveCrudRepository;
//import reactor.core.publisher.Flux;
//import reactor.core.publisher.Mono;


@RestController
@RequestMapping(value = "/")
public class CustomerController {


  private  final CustomRepository customRepository;
    private  final ProductRepository productRepository;


    public CustomerController(CustomRepository customRepository, ProductRepository productRepository) {
        this.customRepository = customRepository;
        this.productRepository = productRepository;

    }

    //Get from Customer credentials as name ,password
    @GetMapping("/currentcustomer/{id}")
    private Customer getcurrent(@RequestBody Customer cust, @RequestParam Integer id ){
        return customRepository.findById(id
        ).get();
    }


        @GetMapping("/listproduct")
        public String productList (@RequestBody Product product, @RequestParam(value = "name_product", required = false) String name,
                @RequestParam(value = "final_price", required = false) Double price){
            productRepository.findAll();
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














