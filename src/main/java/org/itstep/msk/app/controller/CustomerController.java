package org.itstep.msk.app.controller;

import org.itstep.msk.app.entity.Customer;
import org.itstep.msk.app.service.ServiceCustomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

//import org.springframework.data.repository.reactive.ReactiveCrudRepository;
//import reactor.core.publisher.Flux;
//import reactor.core.publisher.Mono;

/**
   @author  shele
 */

@RestController
@RequestMapping(value = "/customers")
public class CustomerController {

    private final ServiceCustomer serviceCustomer;

    @Autowired
    public CustomerController(ServiceCustomer serviceCustomer) {
        this.serviceCustomer = serviceCustomer;
    }


    //Get from Customer credentials as name ,password
    @GetMapping("/{id}")
    public Optional<Customer> retrieveCustomer(@PathVariable Integer id) {
        return serviceCustomer.findById(id);
    }

    //Get customer by name , email
    @GetMapping("/find/{name}")
    public Customer FindByName(@PathVariable String name) {

        return serviceCustomer.retrieveCustomerByName(name);
    }



    //Upgrade customer should return a new Customer with  replacing name , email
    @PutMapping("/update/{id}")
    public Customer updateCustomer(@RequestBody Customer customer
            , @PathVariable Integer id) {
        return serviceCustomer.changeCustomer(id);

    }

    //Should  delete customer from db  by his id
    @DeleteMapping("/delete/{id}")
    public void removeCustomer(@PathVariable Integer id) {
        serviceCustomer.deleteCustomerById(id);
    }

    

}














