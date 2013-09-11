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
 * from here http://static.springsource.org/spring/docs/3.2.x/spring-framework-reference/html/testing.html
 * 11.3.6 Spring MVC Test Framework
 * <p/>
 * and see this repo
 * https://github.com/SpringSource/spring-framework/tree/master/spring-test-mvc/src/test/java/org/springframework/test/web/servlet/samples
 */
@RunWith(MockitoJUnitRunner.class)
public class RedirectControllerTest {

    protected MockMvc mockMvc;

    @Mock
    private AdvertDao advertDaoMock;

    @InjectMocks
    private RedirectController redirectController = new RedirectController();

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders
                .standaloneSetup(redirectController)
                .alwaysExpect(status().isOk())
                .alwaysDo(print())
                .build();
    }

    @Test
    public void testGoToAdverts() throws Exception {
        mockMvc.perform(get(REQUEST_ADVERTS_LIST))
                .andExpect(view().name(PAGE_ADVERTS_LIST))
                .andExpect(model().attributeExists(ATTRIBUTE_ADVERTS, ATTRIBUTE_PAGE));
    }

    @Test
    public void testGoToAddPage() throws Exception {
        mockMvc.perform(get(REQUEST_GOTO_ADD_ADVERT))
                .andExpect(view().name(PAGE_ADD_ADVERT))
                .andExpect(model().attributeExists(ATTRIBUTE_SECTIONS, ATTRIBUTE_OPERATIONS));
    }
}
