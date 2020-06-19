package org.itstep.msk.app.service;

import org.itstep.msk.app.entity.Product;
import org.itstep.msk.app.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServiceProductImp {

    @Autowired
    private ProductRepository productRepository;

    @Query("SELECT name_product FROM product")
    public void findbyNameProduct(){
       Optional<Product> productOptional = Optional.of(new
               Product());

        if(!productOptional.get().getName().equals(productOptional.get().toString().isEmpty())) {
            Product product = new Product();
            productRepository.save(product);
        }



        }
        @Query("SELECT * FROM product")
        public void findAllofProduct(){
            productRepository.findAll()
                    .stream()
                        .distinct();

        }
        @Query("SELECT * FROM product WHERE p.id =?")
        public void deleteProductfromBucket(){
            Optional<Product> productOptional = Optional.of(new Product());
                productRepository.findById(productOptional.get().getId());

                if (productOptional== null){
                    Product prod1 = new Product();
                    prod1.getId();
                    productRepository.save(prod1);
                }

        }






    }

