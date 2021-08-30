package org.itstep.msk.app.repository;

import org.itstep.msk.app.entity.Cart;
import org.itstep.msk.app.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CartRepository extends JpaRepository<Cart,Integer> {
    Product getBySpecificTitle(@Param("totalprice") Double price);
}
