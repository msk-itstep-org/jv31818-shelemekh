package org.itstep.msk.app.service;


import org.itstep.msk.app.entity.Customer;
import org.itstep.msk.app.entity.Product;
import org.itstep.msk.app.repository.CustomRepository;
import org.itstep.msk.app.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.List;
import java.util.TimeZone;

    @Service
    public class AdminServiceImp {
        private  final ProductRepository productRepository;
         private final CustomRepository customRepository;

            @Autowired
            public AdminServiceImp(ProductRepository productRepository, CustomRepository customRepository) {
                this.productRepository = productRepository;
                this.customRepository = customRepository;
            }

        @Query("SELECT name_product, final_price FROM product GROUP BY final_price")
        public  String updateProduct(String  name){
          Product product = new Product();
            productRepository.findById(product.getId());
           productRepository.save(product);

           return name;


        }

        public void deleteCustomerOnDate(){
            Customer customer = new Customer();
            if( customer.getName()!= null){
                customRepository.delete(customer);


            }

        }

        public void findAllCustomer(){
         customRepository.findAll()
                 .forEach(Customer::getProduct);
        }
    }
