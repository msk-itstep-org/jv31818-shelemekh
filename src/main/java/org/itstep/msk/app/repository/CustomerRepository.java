package org.itstep.msk.app.repository;

import org.itstep.msk.app.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    @Query("SELECT c from Customer c where c.name = :name")
    Customer findByName(String name);

    @Query("SELECT c from Customer c where c.email= :email")
    Customer getCustomerByEmail(@Param("email") String email);

    @Query(value = "DELETE c from Customer c where с.id = :id", nativeQuery = true)
    void deleteById(Integer id);


}
