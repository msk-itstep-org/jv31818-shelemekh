package org.itstep.msk.app.service;


import org.itstep.msk.app.entity.Customer;
import org.itstep.msk.app.repository.CustomRepository;
import org.itstep.msk.app.repository.ReactiveCustomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ReactCustomServImplement {
    private final ReactiveCustomRepository reactiveCustomRepository;

    @Autowired
    public ReactCustomServImplement(ReactiveCustomRepository reactiveCustomRepository) {
        this.reactiveCustomRepository = reactiveCustomRepository;
    }




    public Flux<Integer> allCustomer(){
        return reactiveCustomRepository.findAll()
                .take(5);
    }

    public Mono<Customer> addOne(Customer customer){
        return reactiveCustomRepository.save(customer.getId());

    }


}
