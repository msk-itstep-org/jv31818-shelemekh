package org.itstep.msk.app.repository;

import org.itstep.msk.app.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomRepo extends JpaRepository<Customer,Integer> {
    Customer findByEmail(String email);

    Customer findByID(Integer id);

}
