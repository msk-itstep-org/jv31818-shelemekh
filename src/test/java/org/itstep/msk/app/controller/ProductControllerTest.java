package org.itstep.msk.app.controller;

import lombok.SneakyThrows;
import org.itstep.msk.app.entity.Product;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
class ProductControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    @SneakyThrows
    public void getAllProductTest(){
        mvc.perform(get("/products/all")).andExpect(status().isOk());

    }
        @Test
        @SneakyThrows
    public void  testGetOneProduct(){
        //in case , if there is none of rows  test will be passed
        mvc.perform(get("/products/find/2")).andExpect(status().is2xxSuccessful());
    }


}