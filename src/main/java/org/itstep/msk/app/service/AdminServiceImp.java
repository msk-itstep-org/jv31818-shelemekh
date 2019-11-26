package org.itstep.msk.app.service;


import javafx.scene.input.DataFormat;
import org.itstep.msk.app.entity.Customer;
import org.itstep.msk.app.entity.Product;
import org.itstep.msk.app.repository.CustomRepository;
import org.itstep.msk.app.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.TimeZone;

@Service
public class AdminServiceImp {

    @Autowired
    private CustomRepository customRepository;

    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Query("SELECT name_product, final_price FROM product")
    public  String updateProduct(String  name){
        Product product = new Product();
        product.setName("");
        product.setTotalPrice(0.0);
        productRepository.save(product);

        return name;


    }

    public void deleteCustomerOnDate(){
        Customer customer = new Customer();
        if(customer.getPhoneNumber()== null){

            customRepository.delete(customer);

        }

    }

    public void findAllCustomer(){
        customRepository.findAll().stream()
                .limit(100)
                .distinct();
    }
}
