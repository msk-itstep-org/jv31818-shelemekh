package org.itstep.msk.app.service;

import lombok.SneakyThrows;
import org.itstep.msk.app.entity.Customer;
import org.itstep.msk.app.exeption.CustomerException;
import org.itstep.msk.app.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ServiceCustomer {

    private final CustomerRepository customerRepository;

    @Autowired
    public ServiceCustomer(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    // Get customer by his name , the name should not be empty
    @SneakyThrows
    public Customer getCustomerByName(String name) {
        if (name == null) {
            throw new NoSuchFieldException("customer with such" + name + " does not exist");
        }
        return customerRepository.findByName(name);
    }

    //Retrieve all customers where his email is not null
    @Cacheable("storeCache")
    public List<Customer> getAllCustomer() {
        return new ArrayList<Customer>(customerRepository.findAll());
    }

    // Get specific customer by his id
    @SneakyThrows
    @Cacheable(value = "storeCache", key = "#customerId")
    public Optional<Customer> findById(Integer customerId) {
        return Optional.ofNullable(customerRepository.findById(customerId).orElseThrow(
                () -> new org.webjars.NotFoundException("not such " + customerId + " found")));
    }

    /**
     * Updates email and name of customer
     *
     * @param customerId
     * @return customer with upgrading email and name
     */
    @CachePut(value = "storeCache", key = "#customerId")
    public Customer changeCustomerEmailAndName(Integer customerId) {
        Optional<Customer> customerOptional = customerRepository.findById(customerId);
        if (customerOptional.isPresent()) {
            Customer customer1 = new Customer();
            customer1.setEmail(customerOptional.get().getEmail());
            customer1.setName(customerOptional.get().getName());
            customerRepository.save(customer1);
            return customer1;
        }
        return customerOptional.orElseThrow(() -> new DataAccessResourceFailureException("not such customer found"));
    }


    /**
     * Delete by specified id and delete from cache
     *
     * @param cId
     */
    @CacheEvict(value = "storeCache", key = "#cId")
    public void deleteCustomerById(Integer cId) {
        Optional<Customer> optionalCustomer = Optional.ofNullable(customerRepository.findById(cId)
                .orElseThrow(() -> new CustomerException("does not exists ", HttpStatus.NOT_FOUND)));
        customerRepository.delete(optionalCustomer.get());
    }


    /**
     * Check for duplicates emails of customer
     *
     * @param email
     * @return
     */
    public boolean isCustomerEmailUnique(String email) {
        if (email == null || email.isEmpty()) {
            return false;
        }
        Customer customerByEmail = customerRepository.getCustomerByEmail(email);
        List<String> emails = customerRepository.customerEmails(email);
        if (emails.contains(customerByEmail.getEmail())) {
            return false;
        }
        return true;
    }
}

