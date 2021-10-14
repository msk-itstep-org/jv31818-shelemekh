package org.itstep.msk.app.service;

import org.itstep.msk.app.entity.Customer;
import org.itstep.msk.app.repository.CustomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**+
 * @author shele
 */
@Service
public class CustomerDetails implements UserDetailsService {


    private final CustomRepository customerRepo;

    @Autowired
    public CustomerDetails(CustomRepository customerRepo) {
        this.customerRepo = customerRepo;
    }


    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        //Get such customer with his name from db , if not exists throw exception
        Customer customer = customerRepo.findByName(name);
            return new CustomerDetailsImpl(customer);




    }
}
