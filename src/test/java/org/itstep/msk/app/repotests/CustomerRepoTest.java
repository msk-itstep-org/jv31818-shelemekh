package org.itstep.msk.app.repotests;


import org.itstep.msk.app.entity.Customer;
import org.itstep.msk.app.repository.CustomerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.Collections;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;


@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@DataJpaTest
public class CustomerRepoTest {

    @Autowired
    private CustomerRepository customRepository;
    @Autowired
    private TestEntityManager manager;


    @Test
    public void testGetCustomByEmail() {
        String email = "ravi@gmail.com";
        Customer customer = customRepository.getCustomerByEmail(email);

        assertNotNull(customer);
    }


}
