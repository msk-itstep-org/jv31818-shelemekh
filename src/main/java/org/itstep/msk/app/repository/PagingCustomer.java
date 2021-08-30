package org.itstep.msk.app.repository;

import org.itstep.msk.app.entity.Customer;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PagingCustomer  extends PagingAndSortingRepository<Customer,Integer> {
}
