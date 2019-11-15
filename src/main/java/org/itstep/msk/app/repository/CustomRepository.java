package org.itstep.msk.app.repository;

import org.itstep.msk.app.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomRepository extends JpaRepository<Customer,Integer> {

}
