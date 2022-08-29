package org.itstep.msk.app.repository;

import org.itstep.msk.app.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query("SELECT p from Product p where p.id =:id")
    Optional<Product> findById(@Param("id") Integer id);

    @Query("SELECT p from Product p where p.name =: name and p.name is not null ")
    Optional<Product> findByName(@Param("name") String name);
}

