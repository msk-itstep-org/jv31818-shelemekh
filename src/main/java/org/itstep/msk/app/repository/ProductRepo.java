package org.itstep.msk.app.repository;

import org.itstep.msk.app.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepo extends JpaRepository<Product, Integer> {

    Product getByIdContains(Integer id);

    List<Product> findAllByChecklist_customer(String name);
}
