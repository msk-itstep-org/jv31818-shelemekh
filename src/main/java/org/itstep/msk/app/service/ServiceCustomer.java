package org.itstep.msk.app.service;

import javassist.NotFoundException;
import lombok.SneakyThrows;
import org.itstep.msk.app.entity.Customer;
import org.itstep.msk.app.repository.CustomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
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
    public Customer retrieveCustomerByName(String name) {
        if (name == null) {
            throw new NoSuchFieldException("customer with such" + name + " does not exist");
        }
        return customerRepository.findByName(name);
    }

    //Retrieve all customers from db where his email is not null
    public List<Customer> retrieveAllCustomerByEmail() {
        return customerRepository.findAll()
                .stream()
                //    .map(Customer::getName)
                .filter(Objects::nonNull)
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
    public Customer changeCustomer(Integer id) {
        Optional<Customer> optioncust = Optional.of(new Customer());
        if (!optioncust.isPresent()) {
            try {
                throw new NotFoundException(" nothing to change" + id);
            } catch (NotFoundException e) {
                e.printStackTrace();
            }

        }
        Customer customer = new Customer();
        customer.setEmail(customer.getEmail());
        customer.setName(customer.getName());
        return customerRepository.save(customer);
    }

    /**
     * Delete by specified id param
     *
     * @param id
     */
    public void deleteCustomerById(Integer id) {
        customerRepository.deleteById(id);
        if (id == null) {
            try {
                throw new NoSuchFieldException("not found this id :" + id);
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Check for duplicates in emails
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

