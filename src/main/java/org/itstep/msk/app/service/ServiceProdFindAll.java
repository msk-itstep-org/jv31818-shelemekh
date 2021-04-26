package org.itstep.msk.app.service;

import org.itstep.msk.app.repository.ProductRepoFindAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

@Service
public class ServiceProdFindAll {

    private final ProductRepoFindAll productRepoFindAll;

    @Autowired
    public ServiceProdFindAll(ProductRepoFindAll productRepoFindAll) {
        this.productRepoFindAll = productRepoFindAll;
    }

    @Query("select * from product where p.final_price = ?")
    public void  searchAllProduct(){
      productRepoFindAll.findAll();

    }

}
