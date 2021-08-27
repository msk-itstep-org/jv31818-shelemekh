package org.itstep.msk.app.repository;

import org.itstep.msk.app.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface CustomRepository extends JpaRepository<Customer,Integer> {
    Customer findByName (String name);

    @Query("SELECT c from Customer c where c.email= :email")
    public Customer getCustomerByEmail(@Param("email") String email);


}
