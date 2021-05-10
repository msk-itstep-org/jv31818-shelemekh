package org.itstep.msk.app.controller;

import org.itstep.msk.app.entity.Customer;
import org.itstep.msk.app.entity.Product;
import org.itstep.msk.app.repository.CustomRepository;
import org.itstep.msk.app.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

//import org.springframework.data.repository.reactive.ReactiveCrudRepository;
//import reactor.core.publisher.Flux;
//import reactor.core.publisher.Mono;


@RestController
@RequestMapping(value = "/customer")
public class CustomerController {


  private  final CustomRepository customRepository;
    private  final ProductRepository productRepository;

    @Autowired
    public CustomerController(CustomRepository customRepository, ProductRepository productRepository) {
        this.customRepository = customRepository;
        this.productRepository = productRepository;

    }

    //Get from Customer credentials as name ,password
    @GetMapping("/find/{id}")
    private Optional<Customer> getcurrent(@PathVariable Integer id){
        return customRepository.findById(id).filter(customer -> customer.getId()!= null);


    }
//Get all products from db
        @GetMapping("/listproduct")
        public List<Product> productList (){
          return productRepository.findAll().stream()
            .distinct().collect(Collectors.toList());


        }

        @GetMapping("/listproduct/{id}")
        public ResponseEntity<Product> getCurrentProduct (@PathVariable Integer id){
            Optional<Product> optionalProduct = productRepository.findById(id);
            if (optionalProduct.isPresent())
                return ResponseEntity.ok(optionalProduct.get());
            return ResponseEntity.notFound().build();
        }



        @DeleteMapping("/delete/{id}")
        ResponseEntity<?> delete (@PathVariable Integer id){
            customRepository.deleteById(id);
                return ResponseEntity.noContent().build();
        }

    }














