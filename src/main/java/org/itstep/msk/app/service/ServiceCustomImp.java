package org.itstep.msk.app.service;

import org.itstep.msk.app.entity.Customer;
import org.itstep.msk.app.repository.CustomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

@Service
public class ServiceCustomImp {

    @Autowired
    private CustomRepository customRepository;


    @Query("select c FROM customer c WHERE c.id")
    public  void  findCustomerOnId(){
        Customer customer = new Customer();
        customRepository.findById(customer.getId());

        if (customer == null) {
            Customer customer1 = new Customer();
            customer1.getId();
            customRepository.save(customer1);
        }

    }


}
