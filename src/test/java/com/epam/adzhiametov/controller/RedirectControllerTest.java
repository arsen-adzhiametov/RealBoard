package com.epam.adzhiametov.controller;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by Arsen Adzhiametov on 7/31/13.
 * from here http://static.springsource.org/spring/docs/3.2.x/spring-framework-reference/html/testing.html
 * 11.3.6 Spring MVC Test Framework
 *
 * and see this repo
 * https://github.com/SpringSource/spring-framework/tree/master/spring-test-mvc/src/test/java/org/springframework/test/web/servlet/samples
 */
@Ignore
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations={
        "file:src/main/webapp/WEB-INF/applicationContext.xml",
        "file:src/main/webapp/WEB-INF/mvc-dispatcher-servlet.xml"})
public class RedirectControllerTest {

    protected MockMvc mockMvc;

    @Autowired
    private WebApplicationContext wac;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void testGoToAdverts() throws Exception {
        mockMvc.perform(get("/adverts"))
                .andExpect(status().isOk())
                .andExpect(view().name("advert_list"))
                .andExpect(model().attributeExists("adverts", "page"));
    }

    @Test
    public void testGoToAddPage() throws Exception {
        mockMvc.perform(get("/gotoadd"))
                .andExpect(status().isOk())
                .andExpect(view().name("add_advert"))
                .andExpect(model().attributeExists("sectionValues", "operationValues"));
    }
}
