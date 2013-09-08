package com.epam.adzhiametov.dao;

import com.epam.adzhiametov.model.Advert;
import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Arsen Adzhiametov on 7/31/13.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/test/java/com/epam/adzhiametov/dao/testApplicationContext.xml"})
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class, DbUnitTestExecutionListener.class})
@DatabaseSetup(value = "file:src/test/java/com/epam/adzhiametov/dao/databaseState.xml", type = DatabaseOperation.CLEAN_INSERT)
public class AdvertDaoTest {

    @Autowired
    private AdvertDao advertDao;

    private Advert advert;

    @Before
    public void setUp() {
        advert = new Advert();
        advert.setId(1);
        advert.setTitle("title1");
        advert.setType("type1");
        advert.setText("text1");
        advert.setSection("section1");
        advert.setName("name1");
        advert.setTime(Calendar.getInstance());
        advert.setPhone("phone1");
        advert.setPrice(new BigDecimal(1));
    }

    @After
    public void tearDown() {
        advertDao = null;
    }

    @Test
    public void testFindRange() throws Exception {
        List<Advert> advertsFound = advertDao.findRange(1, 1);
        assertTrue(advertsFound.size() == 1);
    }

    @Test
    public void testFind() throws Exception {
        List<Advert> advertsFound = advertDao.find(advert.getPhone());
        assertEquals(advertsFound.get(0), advert);
    }

    @Test
    public void testCreate() throws Exception {
        Advert persisted = advertDao.create(advert);
        Advert advertFound = advertDao.read(persisted.getId());
        assertEquals(advertFound, persisted);
    }

    @Test
    public void testRead() throws Exception {
        Advert advertFound = advertDao.read(advert.getId());
        assertEquals(advertFound, advert);
    }

    @Test
    public void testFindAll() throws Exception {
        List<Advert> advertsFound = advertDao.findAll();
        assertTrue(advertsFound.size() == 2);
    }

    @Test
    public void testDelete() throws Exception {
        List<Advert> advertsFound = advertDao.findAll();
        for (Advert toDelete : advertsFound) {
            advertDao.delete(toDelete);
        }
        advertsFound = advertDao.findAll();
        assertTrue(advertsFound.size() == 0);
    }
}
