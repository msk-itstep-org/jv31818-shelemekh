package org.itstep.msk.app.service;

import org.itstep.msk.app.entity.Customer;
import org.itstep.msk.app.repository.CustomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServiceCustomImp {

    @Autowired
    private CustomRepository customRepository;


    @Query("SELECT id FROM customer")
    public  void  findCustomerOnId(){
        Optional<Customer> customer = Optional.of(new Customer());
        customRepository.findById(customer.get().getId());

        if (customer == null) {
            Customer customer1 = new Customer();
            customer1.getId();
            customRepository.save(customer1);
        }

    }


}
