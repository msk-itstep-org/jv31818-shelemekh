package org.itstep.msk.app.repotests;


import org.itstep.msk.app.entity.Customer;
import org.itstep.msk.app.repository.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.transaction.annotation.Transactional;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.containers.startupcheck.OneShotStartupCheckStrategy;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;




@DataJpaTest
@Transactional
//@TestPropertySource("/application-test.properties")
//@ExtendWith(SpringExtension.class)
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

@Testcontainers
public class CustomerRepoTest {

    @Autowired
    private CustomerRepository customRepository;

    private Customer customer;

    @Container
    private static MySQLContainer container = (MySQLContainer) new MySQLContainer("mysql:8.0.26")
            .withStartupCheckStrategy(
                    new OneShotStartupCheckStrategy().withTimeout(Duration.ofSeconds(30))
            );


    @DynamicPropertySource
    private static void initProps(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", container::getJdbcUrl);
        registry.add("spring.datasource.username", container::getUsername);
        registry.add("spring.datasource.password", container::getPassword);
        registry.add("spring.datasource.driver-class-name",container::getDriverClassName);
    }

    @Test
    void getContainerIp(){
        assertThat(container.getContainerId()).isNotNull();
    }

    @BeforeEach
    void setUp() {
        customRepository.deleteAll();
        customer = new Customer("12344ert", "Ivan", "zreo041990@gmai.com");
        customer.setId(2);
        customer.setPhoneNumber("+38745699934");
        customRepository.save(customer);
    }


    @Test
    //  @Sql("/customer_test.sql")
    public void testShouldWorkWell() {
        Customer saveCustomer = customRepository.findByName("Ivan");
        assertThat(saveCustomer.getName()).isNotEmpty();

    }

    @Test
    // @Sql("/customer_test.sql")
    public void updateTest() {
        customer.setName("Mike");
        customRepository.save(customer);

        var foundCustomer = customRepository.findByName(customer.getName());
        assertEquals("Mike", foundCustomer.getName());
    }

    @Test
    //  @Sql("/customer_test.sql")
    public void deleteTest() {
        customRepository.delete(customer);
        assertFalse(customRepository.existsById(customer.getId()));
    }
}
