package com.epam.adzhiametov.controller;

import com.epam.adzhiametov.dao.AdvertDao;
import com.epam.adzhiametov.enumeration.*;
import com.epam.adzhiametov.model.Advert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RedirectController {

    public static final int ITEMS_ON_PAGE = 5;

    @Autowired
    AdvertDao advertDao;

    @RequestMapping(value = "/adverts", method = RequestMethod.GET)
    public String goToAdverts(ModelMap model) {
        model.addAttribute("adverts", advertDao.findRange(1, ITEMS_ON_PAGE));
        model.addAttribute("page", 1);
        return "advert_list";
    }

    @RequestMapping(value = "/gotoadd", method = RequestMethod.GET)
    public String goToPage(ModelMap model) {
        model.addAttribute("advert", new Advert());
        model.addAttribute("sectionValues", Section.values());
        model.addAttribute("operationValues", Operation.values());
        return "add_advert";
    }
}