package org.itstep.msk.app.service;

import org.itstep.msk.app.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceProductImp {

    private ProductRepository productRepository;

    @Autowired
    public ServiceProductImp(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    public void deleteProductFromBucket(Integer id){
            productRepository.deleteById(id);
        }






    }

