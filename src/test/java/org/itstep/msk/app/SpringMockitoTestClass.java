package org.itstep.msk.app;


import org.itstep.msk.app.controller.CustomerController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.setup.StandaloneMockMvcBuilder;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SpringMockitoTestClass {

    private MockMvc mockMvc;

    @InjectMocks
    private CustomerController controller;

    @Before
    public void go()throws Exception{
        mockMvc= MockMvcBuilders.standaloneSetup(controller)
                .build();

    }
    @Test
    public void registerTest() throws Exception{
        mockMvc.perform(
                MockMvcRequestBuilders.get("/customer")
        )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("register"));


    }




}
