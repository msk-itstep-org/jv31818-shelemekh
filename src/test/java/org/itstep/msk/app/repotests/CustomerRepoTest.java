package org.itstep.msk.app.repotests;

import org.itstep.msk.app.entity.Customer;
import org.itstep.msk.app.repository.CustomRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
@WebAppConfiguration
public class CustomerRepoTest {

    @Autowired
    private CustomRepository customRepository;
    @Autowired
    private TestEntityManager manager;

    @Test
    public void testCreateCustomer(){
        Customer precust =manager.find(Customer.class,1);
        Customer customer = new Customer("1234","njj");

        Customer saveCust= customRepository.save(customer);

        assertThat(saveCust.getId()).isGreaterThan(0);
    }
}
