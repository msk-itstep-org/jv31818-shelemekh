package org.itstep.msk.app;

import org.itstep.msk.app.controller.CustomerController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringJUnit4ClassRunner.class)
public class SpringTestCase {

    private MockMvc mockMvc;

    @InjectMocks
    private CustomerController controller;

    @Before
    public void goahead()throws Exception{
        mockMvc = MockMvcBuilders.standaloneSetup(controller)
                .build();



    }
    @Test
    public void registerTest(){
        try {
            mockMvc.perform(
                  MockMvcRequestBuilders  .get("/register")


            )
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.content().string("register"));


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
