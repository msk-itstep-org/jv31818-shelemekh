package org.itstep.msk.app.service;

import javassist.NotFoundException;
import lombok.SneakyThrows;
import org.itstep.msk.app.entity.Customer;
import org.itstep.msk.app.repository.CustomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ServiceCustomer {

    private final CustomRepository customerRepository;



    @Autowired
    public ServiceCustomer(CustomRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    // Get customer by his name , the name should not be empty
    @SneakyThrows
    public Customer retrieveCustomerByName(String name){
            return customerRepository.findByName(name);
    }
    //Retrieve all customers from db where his email is not null
    public List<Customer> retrieveAllCustomerByEmail(){
      return  customerRepository.findAll()
                .stream()
                //    .map(Customer::getName)
                    .filter(customer -> customer.getEmail()!= null)
                .collect(Collectors.toList());
    }
    // Get specific customer by id
    @SneakyThrows
    public Optional<Customer> findById(Integer id){
        return    customerRepository.findById(id);


    }
    //Update name , email of customer
    public Customer changeCustomer(Integer id){
        Optional<Customer> optioncust = Optional.of(new Customer());
                if(!optioncust.isPresent()){
                    try {
                        throw new NotFoundException(" nothing to change" + id);
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }

                }
                Customer customer = new Customer();
                customer.setEmail(customer.getEmail());
                customer.setName(customer.getName());
         return  customerRepository.save(customer);
    }

    public void deleteCustomerById (Integer id){
        customerRepository.deleteById(id);
            if(id == null){
                try {
                    throw new NoSuchFieldException("not found this id :"+ id);
                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                }
            }
    }


}

