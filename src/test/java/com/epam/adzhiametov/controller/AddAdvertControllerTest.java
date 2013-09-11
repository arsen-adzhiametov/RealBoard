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
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import static com.epam.adzhiametov.controller.MVCConstants.*;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by Arsen Adzhiametov on 7/31/13.
 */
@RunWith(MockitoJUnitRunner.class)
public class AddAdvertControllerTest {

    protected MockMvc mockMvc;

    @Mock
    private AdvertDao mockedAdvertDao;

    @Mock
    private BindingResult mockedBindingResult;

    @Mock
    private Model mockedModel;

    @InjectMocks
    AddAdvertController addAdvertController = new AddAdvertController();

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders
                .standaloneSetup(addAdvertController)
                .alwaysExpect(status().isOk())
                .alwaysDo(print())
                .build();
    }

    @Test
    public void testAddAdvert() throws Exception {
        when(mockedAdvertDao.create(new Advert())).thenReturn(new Advert());
        mockMvc.perform(post(REQUEST_ADD_ADVERT))
                .andExpect(view().name(PAGE_ADVERTS_LIST))
                .andExpect(model().attributeExists(ATTRIBUTE_ADVERTS, ATTRIBUTE_PAGE));
    }


    @Test
    public void testAddAdvertWithErrors() throws Exception {
        when(mockedBindingResult.hasErrors()).thenReturn(true);
        String viewName = addAdvertController.addAdvert(new Advert(), mockedBindingResult, mockedModel);
        assertEquals(viewName, PAGE_ADD_ADVERT);
    }


}
