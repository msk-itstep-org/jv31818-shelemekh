package org.itstep.msk.app.service;

import org.itstep.msk.app.entity.Customer;
import org.itstep.msk.app.entity.Product;
import org.itstep.msk.app.repository.CustomRepository;
import org.itstep.msk.app.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
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

        @Query("SELECT * FROM customer WHERE c.name=?")
    public   List<Customer> findAllCustomerofProduct() {
            Predicate<Customer> preCust =
                    (c)-> c.getName()!= null;


       return (List<Customer>) customRepository.findAll()
               .stream()
               .filter(preCust);
    }





    public void deleteCustomer(){
            Optional<Customer> cust = Optional.of(new Customer());
        if (cust == null) {
            Customer customer2 = new Customer();
            customRepository.delete(customer2);

        }
    }


}
