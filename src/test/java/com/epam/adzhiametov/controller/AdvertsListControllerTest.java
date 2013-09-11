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

import static com.epam.adzhiametov.controller.MVCConstants.*;
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
        mockMvc.perform(get(REQUEST_VIEW_DETAIL_TEST))
                .andExpect(view().name(PAGE_ADVERT_DETAILS))
                .andExpect(model().attributeExists(ATTRIBUTE_ADVERT_DETAIL));
    }

    @Test
    public void testNextPage() throws Exception {
        mockMvc.perform(get(REQUEST_PAGE_TEST))
                .andExpect(view().name(PAGE_ADVERTS_LIST))
                .andExpect(model().attributeExists(ATTRIBUTE_ADVERTS, ATTRIBUTE_PAGE));
    }
}
