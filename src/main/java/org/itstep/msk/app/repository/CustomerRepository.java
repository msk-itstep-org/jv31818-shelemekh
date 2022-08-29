package org.itstep.msk.app.repository;

import org.itstep.msk.app.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    @Query(value = "SELECT c from Customer c where c.name = :name")
    Customer findByName(@Param("name") String name);

    @Query(value = "SELECT c from Customer c where c.email= :email ORDER BY c.email")
    Customer getCustomerByEmail(@Param("email") String email);

    @Query(value = "select c.email from Customer  c  where c.email= :email order by c.email")
    List<String> customerEmails(@Param("email") String email);


    void deleteById(@Param("id") Integer id);

    


}
