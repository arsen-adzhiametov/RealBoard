package com.epam.adzhiametov.dao;

import com.epam.adzhiametov.model.Advert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

import static junit.framework.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Created by Arsen Adzhiametov on 7/31/13.
 * from here http://www.javahotchocolate.com/tutorials/mockito.html#glossary
 */
public class AdvertDaoTestFignia {

    private static final String PHONE_1 = "phone1";
    private static final String PHONE_2 = "phone2";
    private static final long ID_1 = 1L;
    private static final long ID_2 = 2L;
    private AdvertDao advertDao;
    private Advert advert1;
    private Advert advert2;

    @Before
    public void setup() {
        advertDao = mock(AdvertDao.class);

        advert1 = new Advert();
        advert1.setId(ID_1);
        advert1.setTitle("title1");
        advert1.setType("type1");
        advert1.setText("text1");
        advert1.setSection("section1");
        advert1.setName("name1");
        advert1.setTime(Calendar.getInstance());
        advert1.setPhone(PHONE_1);
        advert1.setPrice(new BigDecimal(1));

        advert2 = new Advert();
        advert2.setId(ID_2);
        advert2.setTitle("title2");
        advert2.setType("type2");
        advert2.setText("text2");
        advert2.setSection("section2");
        advert2.setName("name2");
        advert2.setTime(Calendar.getInstance());
        advert2.setPhone(PHONE_2);
        advert2.setPrice(new BigDecimal(2));
    }

    private final boolean checkStateResult(Advert a, Advert b) {
        assertEquals(a.getName(), b.getName());
        assertEquals(a.getPhone(), b.getPhone());
        assertEquals(a.getPrice(), b.getPrice());
        assertEquals(a.getText(), b.getText());
        return true;
    }

    @Test
    public void testFindRange() throws Exception {
        List<Advert> all = new LinkedList<Advert>();
        all.add(advert1);
        when(advertDao.findRange(1, 1)).thenReturn(all);
        List<Advert> result = advertDao.findRange(1, 1);
        verify(advertDao).findRange(1, 1);
        assertNotNull(result);
        assertTrue(checkStateResult(advert1, result.get(0)));
    }

    @Test
    public void testFind() throws Exception {
        List<Advert> all = new LinkedList<Advert>();
        all.add(advert1);
        when(advertDao.find(PHONE_1)).thenReturn(all);
        List<Advert> result = advertDao.find(PHONE_1);
        verify(advertDao).find(PHONE_1);
        assertNotNull(result);
        assertTrue(checkStateResult(advert1, result.get(0)));
    }

    @Test
    public void testCreate() throws Exception {
        when(advertDao.create(advert1)).thenReturn(advert1);
        Advert result = advertDao.create(advert1);
        verify(advertDao).create(result);
        assertNotNull(result);
        assertTrue(checkStateResult(advert1, result));
    }

    @Test
    public void testRead() throws Exception {
        when(advertDao.read(ID_1)).thenReturn(advert1);
        Advert result = advertDao.read(ID_1);
        verify(advertDao).read(ID_1);
        assertNotNull(result);
        assertTrue(checkStateResult(advert1, result));
    }

    @Test
    public void testDelete() throws Exception {
        doNothing().doThrow(new IllegalStateException())
                .when(advertDao).delete(advert1);
        when(advertDao.read(ID_1)).thenReturn(advert1);
        advertDao.delete(advert1);
        verify(advertDao).delete(advert1);
    }

    @Test
    public void testFindAll() throws Exception {
        List<Advert> all = new LinkedList<Advert>();
        all.add(advert1);
        all.add(advert2);
        when(advertDao.findAll()).thenReturn(all);
        List<Advert> result = advertDao.findAll();
        verify(advertDao).findAll();
        assertEquals(2, result.size());
        assertTrue(checkStateResult(advert1, result.get(0)));
        assertTrue(checkStateResult(advert2, result.get(1)));
    }
}
