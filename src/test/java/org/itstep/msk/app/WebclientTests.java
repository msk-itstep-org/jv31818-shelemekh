package org.itstep.msk.app;

import org.itstep.msk.app.controller.ProductFluxWebController;
import org.itstep.msk.app.entity.Product;
import org.itstep.msk.app.repository.ProductRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.parameters.P;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@RunWith(SpringRunner.class)
@WebMvcTest(ProductFluxWebController.class)
public class WebclientTests {

    @Autowired
    private WebClient webClient;

    @MockBean
    private ProductRepository productRepository;

    @MockBean
    private Product product;

    @Test
    public void testWebclientget()throws Exception{
       Flux<Product> prod = webClient.get().uri("/getproduct").retrieve()
                .bodyToFlux(Product.class);
        Assert.assertEquals(prod,product);

    }

}
