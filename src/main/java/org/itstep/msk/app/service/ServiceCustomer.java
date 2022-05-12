package org.itstep.msk.app.service;

import javassist.NotFoundException;
import lombok.SneakyThrows;
import lombok.val;
import org.itstep.msk.app.entity.Customer;
import org.itstep.msk.app.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
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
    public List<Customer> getAllCustomer() {
        return customerRepository.findAll().stream()
                .collect(Collectors.toList());
    }

    // Get specific customer by his id
    @SneakyThrows
    public Optional<Customer> findById(Integer id) {
        return Optional.ofNullable(customerRepository.findById(id).orElseThrow(
                () -> new org.webjars.NotFoundException("not such " + id + " found")));
    }

    /**
     * Updates email and name of customer
     *
     * @param id
     * @return customer with upgrading email and name
     */
    public Customer changeCustomerEmailAndName(Integer id) {
        Optional<Customer> customerOptional = customerRepository.findById(id);
        if (customerOptional.isPresent()) {
            Customer customer1 = new Customer();
            customer1.setEmail(customerOptional.get().getEmail());
            customer1.setName(customerOptional.get().getName());
            customerRepository.save(customer1);
            return customer1;
        }
        return customerOptional.orElseThrow(()-> new DataAccessResourceFailureException("not such customer found"));
    }


    /**
     * Delete by specified id
     *
     * @param id
     */
    public void deleteCustomerById(Integer id) {
        Optional<Customer> optionalCustomer = Optional.ofNullable(customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("does not exists ")));
        customerRepository.delete(optionalCustomer.get());
    }


    /**
     * Check for duplicates emails of customers
     * @param email
     * @return
     */
    public boolean isCustomerEmailUnique(String email) {
        if (email == null) {
            return false;
        }
        Customer customerByEmail = customerRepository.getCustomerByEmail(email);
        List<String> emails = customerRepository.findAll()
                .stream()
                .map(Customer::getEmail)
                .collect(Collectors.toList());
        if (emails.contains(customerByEmail.getEmail())) {
            return false;
        }
        return true;
    }
}

