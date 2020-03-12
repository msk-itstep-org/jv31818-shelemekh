package org.itstep.msk.app.controller;

import jdk.net.SocketFlow;
import org.apache.tomcat.jni.Status;
import org.itstep.msk.app.entity.Customer;
import org.itstep.msk.app.entity.Product;
import org.itstep.msk.app.enums.AppRoles;
import org.itstep.msk.app.repository.ProductRepository;
import org.itstep.msk.app.service.AdminServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@RestController
@RequestMapping(value = "/admin", produces = "application/json")
public class AdminController {


    @Autowired
    private AdminServiceImp adminServiceImp;

    @GetMapping("/panel")
    public String seachAllCustomer(){

        return "panel";

    }

    @PostMapping("/panel")
    @ResponseBody
    public String enterInAdminka(){
        adminServiceImp.findAllCustomer();

        return "redirect:/panel";


    }

    @PutMapping("/admin/update")
    @ResponseBody
    public Product changeProduct(@RequestBody Product prod, @PathVariable String name, @PathVariable Double totalPrice){
        adminServiceImp.updateProduct(name);


        return new Product();

    }


    @DeleteMapping("/admin/delete{id}")
    @ResponseBody
    public Product deleteCustomer( @PathVariable Integer id){
        adminServiceImp.deleteCustomerOnDate();
        if (deleteCustomer(id) == null){
            adminServiceImp.findAllCustomer();
        }else {
            throw new RuntimeException("Customer not found");
        }
           return null;

    }






}
