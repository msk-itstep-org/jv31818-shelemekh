package org.itstep.msk.app.service;


import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.itstep.msk.app.entity.Customer;
import org.itstep.msk.app.entity.Product;
import org.itstep.msk.app.repository.CustomRepository;
import org.itstep.msk.app.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class AdminServiceImp {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CustomRepository customRepository;

    @Transactional(readOnly = true)
    public Product updateProduct(String name) {
        Optional<Product> prod = Optional.of(new Product());
        if (!prod.isPresent()) {
            throw new IllegalArgumentException("not such " + name);
        }
        log.info("create new prod with credetils name");
        Product product = new Product();
        product.setName(prod.get().getName());
        return productRepository.save(product);


    }

    @SneakyThrows
    public void deleteCustomerOn() {
        Customer customer = new Customer();
        if (customer.getName() != null) {
            customRepository.delete(customer);
        } else {
            throw new NotFoundException("not such customer with  name");
        }
    }

    public List<Customer> findAllCustomer() {
       List<Customer> customerList= customRepository.findAll()
                .stream().filter(customer -> customer.getId() != null)
                .collect(Collectors.toList());
       if (customerList.isEmpty()){
           return Collections.emptyList();
       }
        return customerList;
    }
}
