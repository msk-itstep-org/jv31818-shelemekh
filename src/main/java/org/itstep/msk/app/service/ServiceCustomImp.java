    package org.itstep.msk.app.service;

    import org.itstep.msk.app.entity.Customer;
    import org.itstep.msk.app.entity.Product;
    import org.itstep.msk.app.repository.CustomRepository;
    import org.itstep.msk.app.repository.ProductRepository;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.data.jpa.repository.Query;
    import org.springframework.data.repository.query.Param;
    import org.springframework.stereotype.Service;
    import org.springframework.web.bind.annotation.RequestBody;
    import reactor.core.publisher.Flux;
    import reactor.core.publisher.Mono;

    import java.util.Comparator;
    import java.util.List;
    import java.util.Optional;
    import java.util.function.BinaryOperator;
    import java.util.function.Consumer;
    import java.util.function.Function;
    import java.util.function.Predicate;
    import java.util.stream.Collectors;

    @Service
    public class ServiceCustomImp {


        private CustomRepository customRepository;
        private ProductRepository productRepository;

        @Autowired
        public ServiceCustomImp(CustomRepository customRepository, ProductRepository productRepository) {
            this.customRepository = customRepository;
            this.productRepository = productRepository;
        }


        public Optional<Customer> findCustomerById() {
            Optional<Customer> cust = Optional.of(new Customer());
            customRepository.findById(cust.get().getId());
            if (!cust.isPresent() ) {
                Customer customer1 = new Customer();
                customer1.getId();
                customRepository.save(customer1);
            }

            return cust;

        }

        @Query("SELECT * FROM customer WHERE c.name=?")
        public Iterable<Customer> findAllCustomerofProduct() {
            return customRepository.findAll();



        }


        public void deleteCustomer() {
            Optional<Customer> cust = Optional.of(new Customer());
            if (cust == null) {
                Customer customer2 = new Customer();
                customRepository.deleteById(customer2.getId());
            }
        }



        public Customer saveinDb(Customer customer) {
            return customRepository.save(customer);
        }


    }
