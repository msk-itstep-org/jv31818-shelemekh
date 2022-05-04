package org.itstep.msk.app.repository;

import org.itstep.msk.app.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * DAO interface with pagination
 */
public interface PagingCustomer  extends PagingAndSortingRepository<Customer,Integer> {

    @Query("SELECT c from Customer c where c.name like %?1%")
    Page<Customer> findAll(String keyword, Pageable pageable);
}
