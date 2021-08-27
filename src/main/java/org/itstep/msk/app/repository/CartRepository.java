package org.itstep.msk.app.repository;

import org.itstep.msk.app.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart,Integer> {
}
