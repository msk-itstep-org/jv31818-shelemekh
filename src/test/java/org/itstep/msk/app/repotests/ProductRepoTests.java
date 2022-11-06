package org.itstep.msk.app.repotests;

import org.itstep.msk.app.entity.Product;
import org.itstep.msk.app.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest(properties = {"spring.jpa.hibernate.ddl-auto=update","spring.flyway.enable=false",
        "spring.jpa.database-platform=org.hibernate.dialect.MySQL5InnoDBDialect"})
@Transactional(propagation = Propagation.NOT_SUPPORTED)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ProductRepoTests extends TestContainerBase {

    @Autowired
    private ProductRepository productRepository;

    private Product saveProduct;


    @BeforeEach
    void setUpDb() {
        productRepository.deleteAll();

        Product entity = new Product();
        entity.setName("Plane");
        entity.setId(4);
        entity.setTotalPrice(12.33);
        saveProduct = productRepository.save(entity);

        assertEquals(entity, saveProduct);

    }
//TODO fix test case with id of product
    @Test
    @DisplayName("get all products test")
  //  @Sql("/product_test.sql")
    void test_find_all_products() {
        List<Product> productList = productRepository.findAll();
        assertThat(productList.size()).isGreaterThan(0);

    }
}
