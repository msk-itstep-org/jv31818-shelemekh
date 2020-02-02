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
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Controller
public class AdminController {
    @Autowired
    ProductRepository productRepository;


    @Autowired
  CustomRepository customRepository;

    @Autowired
    private AdminServiceImp adminServiceImp;



    @GetMapping("/panel")
    public String seachAllCustomer(@RequestBody Customer customer){
        customRepository.findAll().stream().distinct();

        return "panel";

    }





    @PutMapping("/admin/update")
    @ResponseBody
    public String changeProduct(@PathVariable String name,@PathVariable Double totalPrice, Product product){
        adminServiceImp.updateProduct(name);
        adminServiceImp.updateProduct(totalPrice.toString());

        productRepository.save(product);




        return "update";

    }


    @DeleteMapping("/admin/delete{id}")
    @ResponseBody
    public String deleteCustomer( @PathVariable Integer id){
        adminServiceImp.deleteCustomerOnDate();
        if (deleteCustomer(id) == null){
            adminServiceImp.findAllCustomer();
        }else {
            throw new RuntimeException("Customer not found");
        }
           return "Customer have been deleted";

    }






}
