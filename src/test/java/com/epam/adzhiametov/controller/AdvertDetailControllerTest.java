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

import static com.epam.adzhiametov.controller.MVCConstants.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
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
    private AdvertDetailController advertDetailController = new AdvertDetailController();

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders
                .standaloneSetup(advertDetailController)
                .alwaysExpect(status().isOk())
                .alwaysDo(print())
                .build();
    }

    @Test
    public void testViewAllOfAuthor() throws Exception {
        mockMvc.perform(get(REQUEST_ALL_OF_AUTHOR_TEST))
                .andExpect(status().isOk())
                .andExpect(view().name(PAGE_ADVERTS_LIST))
                .andExpect(model().attributeExists(ATTRIBUTE_ADVERTS));
    }
}
