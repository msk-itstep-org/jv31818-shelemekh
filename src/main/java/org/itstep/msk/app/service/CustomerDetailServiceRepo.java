package org.itstep.msk.app.service;

import org.itstep.msk.app.entity.Customer;
import org.itstep.msk.app.repository.CustomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomerDetailServiceRepo implements UserDetailsService {

    private  final CustomRepository customRepository;

        @Autowired
    public CustomerDetailServiceRepo(CustomRepository customRepository) {
        this.customRepository = customRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
            Customer customer= customRepository.findByName(name);
           CustomDetailsClass customDetailsClass=null;
            if (customer!=null){
                customDetailsClass = new CustomDetailsClass(customer);
            }else {
                throw new UsernameNotFoundException("Customer is not exist.."+ name);
            }
        return null;
    }
}
