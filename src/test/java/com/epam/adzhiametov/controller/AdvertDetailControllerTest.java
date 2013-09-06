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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by Arsen Adzhiametov on 7/31/13.
 */
@RunWith(MockitoJUnitRunner.class)
public class AdvertDetailControllerTest {

    protected MockMvc mockMvc;

    @Mock
    private AdvertDao advertDaoMock;

    @InjectMocks
    AdvertDetailController advertDetailController = new AdvertDetailController();

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(advertDetailController).build();
    }

    @Test
    public void testViewAllOfAuthor() throws Exception {
        mockMvc.perform(get("/thisauthor/11"))
                .andExpect(status().isOk())
                .andExpect(view().name("advert_list"))
                .andExpect(model().attributeExists("adverts"));
    }
}
