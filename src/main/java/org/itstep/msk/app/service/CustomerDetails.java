package org.itstep.msk.app.service;

import org.itstep.msk.app.entity.Customer;
import org.itstep.msk.app.entity.CustomerPrincipal;
import org.itstep.msk.app.repository.CustomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomerDetails implements UserDetailsService {

    @Autowired
    private   CustomRepository customerRepo;



    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        Customer customer = customerRepo.findByName(name);
                if (name == null){
                    throw new UsernameNotFoundException(name);
                }

                return new CustomerPrincipal(customer);
    }
}
