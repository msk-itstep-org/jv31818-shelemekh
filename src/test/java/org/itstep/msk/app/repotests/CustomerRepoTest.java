package org.itstep.msk.app.repotests;

import org.hamcrest.collection.IsEmptyCollection;
import org.itstep.msk.app.entity.Customer;
import org.itstep.msk.app.repository.CustomRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.MatcherAssert.assertThat;


@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@DataJpaTest
@SpringBootTest
public class CustomerRepoTest {

    @Autowired
    private CustomRepository customRepository;
    @Autowired
    private TestEntityManager manager;

    @Test
    public void testCreateCustomer(){
      Customer customer = new Customer("1234","Jolly");
      manager.persist(customer);
     // Customer customer1 = new Customer("ert123","Freddy");
     // manager.persist(customer1);
      //actual
        customRepository.deleteAll();

        assertThat(customRepository.findAll(), IsEmptyCollection.empty());


    }




}
