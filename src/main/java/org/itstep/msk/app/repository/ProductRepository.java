package org.itstep.msk.app.repository;

import org.itstep.msk.app.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query("SELECT p from Product p where p.id =:id")
    Optional<Product> findById( Integer id);
}

