package org.itstep.msk.app.service;

import org.itstep.msk.app.entity.Customer;
import org.itstep.msk.app.entity.Product;
import org.itstep.msk.app.repository.CustomRepository;
import org.itstep.msk.app.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Collectors;

@Service
    public class ServiceCustomImp {

        @Autowired
        private CustomRepository customRepository;

        @Autowired
        private ProductRepository productRepository;

        @Query("SELECT * FROM customer WRERE c.id =?")
        public void findCustomerOnId(){
            Optional<Customer> customer = Optional.of(new Customer());
            customRepository.findById(customer.get().getId());

            if (customer == null) {
                Customer customer1 = new Customer();
                customer1.getId();
                customRepository.save(customer1);
            }


        }

    public Flux<Customer> findAllCustomerofProduct(){
            return (Flux<Customer>) Flux.fromIterable(productRepository.findAll())
                 .subscribe(product -> product.getTotalPrice());









        }

    public void deleteCustomer(){
            Optional<Customer> cust = Optional.of(new Customer());
        if (cust == null) {
            Customer customer2 = new Customer();
            customRepository.delete(customer2);

        }
    }


}
