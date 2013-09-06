package com.epam.adzhiametov.controller;

import com.epam.adzhiametov.dao.AdvertDao;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by Arsen Adzhiametov on 7/31/13.
 */
@RunWith(MockitoJUnitRunner.class)
public class AddAdvertControllerTest {

    protected MockMvc mockMvc;

    @Mock
    private AdvertDao advertDaoMock;

    @InjectMocks
    AddAdvertController addAdvertController = new AddAdvertController();

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(addAdvertController).build();
    }

    @Test
    public void testAddAdvert() throws Exception {
        mockMvc.perform(post("/addadvert"))
                .andExpect(status().isOk())
                .andExpect(view().name("advert_list"))
                .andExpect(model().attributeExists("adverts", "page"));
    }
}
