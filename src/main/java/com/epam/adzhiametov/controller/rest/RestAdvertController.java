package com.epam.adzhiametov.controller.rest;

import com.epam.adzhiametov.dao.AdvertDao;
import com.epam.adzhiametov.model.Advert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Arsen Adzhiametov on 7/31/13.
 */
@Controller
public class RestAdvertController {

    @Autowired
    private AdvertDao advertDao;

    @RequestMapping(method = RequestMethod.GET, value = "/advert/{id}", headers = "Accept=application/json, application/xml")
    public
    @ResponseBody
    Advert getAdvert(@PathVariable Integer id) {
        Advert advert = advertDao.read(id);
        return advert;
    }
}
