package com.epam.adzhiametov.controller;

import com.epam.adzhiametov.dao.AdvertDao;
import com.epam.adzhiametov.model.Advert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by Arsen Adzhiametov on 7/31/13.
 */
@RunWith(MockitoJUnitRunner.class)
public class AdvertsListControllerTest {

    protected MockMvc mockMvc;

    @Mock
    private AdvertDao advertDaoMock;

    @InjectMocks
    private AdvertsListController advertsListController = new AdvertsListController();

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.
                standaloneSetup(advertsListController)
                .alwaysExpect(status().isOk())
                .alwaysDo(print())
                .build();
    }

    @Test
    public void testViewDetail() throws Exception {
        when(advertDaoMock.read(anyInt())).thenReturn(new Advert());
        mockMvc.perform(get("/viewdetail/30"))
                .andExpect(view().name("advert_details"))
                .andExpect(model().attributeExists("advertDetail"));
    }

    @Test
    public void testNextPage() throws Exception {
        mockMvc.perform(get("/paging/1"))
                .andExpect(view().name("advert_list"))
                .andExpect(model().attributeExists("adverts", "page"));
    }
}
