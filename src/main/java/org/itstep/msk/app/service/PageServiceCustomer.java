package org.itstep.msk.app.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.itstep.msk.app.entity.Customer;
import org.itstep.msk.app.repository.PagingCustomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PageServiceCustomer {
    public static final int USER_PER_PAGE=5;

    @Autowired
    private PagingCustomer pagingCustomer;

    public Page<Customer> listByPage(int pageNum){
        Pageable pageable = PageRequest.of(pageNum-1, USER_PER_PAGE);
        return pagingCustomer.findAll(pageable);
    }

}
