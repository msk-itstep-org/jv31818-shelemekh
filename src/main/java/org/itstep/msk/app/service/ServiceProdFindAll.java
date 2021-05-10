package org.itstep.msk.app.service;

import org.itstep.msk.app.entity.Product;
import org.itstep.msk.app.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceProdFindAll {

    @Autowired
    public ServiceProdFindAll(ProductRepository prodRepo) {
        this.prodRepo = prodRepo;
    }

    private final ProductRepository prodRepo;


    //Get all products
    public List<Product> searchAllProduct(){
           return  prodRepo.findAll();

    }

}
