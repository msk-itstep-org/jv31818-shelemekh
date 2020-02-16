package org.itstep.msk.app.controller;

import jdk.net.SocketFlow;
import org.apache.tomcat.jni.Status;
import org.itstep.msk.app.entity.Customer;
import org.itstep.msk.app.entity.Product;
import org.itstep.msk.app.enums.AppRoles;
import org.itstep.msk.app.repository.CustomRepository;
import org.itstep.msk.app.repository.ProductRepository;
import org.itstep.msk.app.service.AdminServiceImp;
import org.itstep.msk.app.service.ServiceCustomImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/admin", produces ="application/json")
public class AdminController {
    @Autowired
    ProductRepository productRepository;


    @Autowired
  CustomRepository customRepository;

    @Autowired
    private AdminServiceImp adminServiceImp;



    @GetMapping("/panel")
    @ResponseStatus(HttpStatus.OK)
    public String seachAllCustomer(@RequestBody Customer customer){
        customRepository.findAll().stream().distinct();
        	return "panel";

    }





    @PutMapping("/update")
    @ResponseStatus(HttpStatus.UPGRADE_REQUIRED)
    
    public String changeProduct(@PathVariable String name,@PathVariable Double totalPrice, Product product){
        adminServiceImp.updateProduct(name);
        adminServiceImp.updateProduct(totalPrice.toString());

        productRepository.save(product);

        return "update";

    }


    @DeleteMapping("/delete{id}")
    public String deleteCustomer( @PathVariable Integer id){
        adminServiceImp.deleteCustomerOnDate();
        if (deleteCustomer(id) == null){
        	//List<Customer> li = new ArrayList();
           
			adminServiceImp.findAllCustomer();
        }else {
            throw new RuntimeException("Customer not found");
        }
           return "Customer have been deleted";

    }
    
    
    @PatchMapping(path ="/pathperfom{id}", consumes = "application/json")
    	public Product perfompath(@PathVariable("product_id") Integer id,
    			@RequestBody Product product) {
    	
    	Product product1 = productRepository.findById(id).get();
    	if (product.getId()!= null) {
    		product1.setName(product.getId().toString());
    	}
    	return productRepository.save(product1);
    }






}
