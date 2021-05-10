package org.itstep.msk.app.controller;

import org.itstep.msk.app.entity.Product;
import org.itstep.msk.app.service.ServiceFindByIdImpl;
import org.itstep.msk.app.service.ServiceProdFindAll;
import org.itstep.msk.app.service.ServiceProductImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/products", produces = "application/json")
public class ProductController {

    @Autowired
    private ServiceProdFindAll serviceProdFindAll;

    @Autowired
    private ServiceFindByIdImpl serviceFindById;

    @Autowired
    private ServiceProductImp productImp;



    @GetMapping("/all")
    public List<Product>giveAllProduct(){
       return serviceProdFindAll.searchAllProduct();
    }

    @GetMapping("/product/{id}")
    public Product getMeOneProductByName(@PathVariable Integer id){
      return serviceFindById.findById(id);

    }
    @DeleteMapping("/product/{id}")
    public void deleteProdById(@PathVariable Integer id){
        productImp.deleteProductFromBucket(id);
    }
    
}
