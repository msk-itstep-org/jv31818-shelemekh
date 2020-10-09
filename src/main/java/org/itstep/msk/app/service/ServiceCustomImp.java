    package org.itstep.msk.app.service;

    import org.itstep.msk.app.entity.Customer;
    import org.itstep.msk.app.entity.Product;
    import org.itstep.msk.app.repository.CustomRepository;
    import org.itstep.msk.app.repository.ProductRepository;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.data.jpa.repository.Query;
    import org.springframework.stereotype.Service;
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


        public Optional<Customer> findCustomerOnId() {
            Optional<Customer> cust = Optional.of(new Customer());
            customRepository.findById(cust.get().getId());

            if (cust == null) {
                Customer customer1 = new Customer();
                customer1.getId();
                customRepository.save(customer1);
            }

            return cust;

        }

        @Query("SELECT * FROM customer WHERE c.name=?")
        public List<Customer> findAllCustomerofProduct() {
            Predicate<Customer> preCust =
                    (c) -> c.getName() != null;
            return customRepository.findAll()
                    .stream()
                    .filter(preCust)
                    .collect(Collectors.toList());
        }


        public void deleteCustomer() {
            Optional<Customer> cust = Optional.of(new Customer());
            if (cust == null) {
                Customer customer2 = new Customer();
                customRepository.deleteById(customer2.getId());
            }

        }


        public Customer saveinDb(Customer customer) {
            Optional<Customer> cust = Optional.of(new Customer());
            if (!cust.isPresent()) {
                Customer customer1 = new Customer();
                customer1.setName(customer.getName());
                customer1.setPassword(customer.getPassword());

            }
            return customRepository.save(customer);
        }
    }
