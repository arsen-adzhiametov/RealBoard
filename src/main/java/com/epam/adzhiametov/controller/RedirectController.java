package com.epam.adzhiametov.controller;

import com.epam.adzhiametov.dao.AdvertDao;
import com.epam.adzhiametov.enumeration.Operation;
import com.epam.adzhiametov.enumeration.Section;
import com.epam.adzhiametov.model.Advert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RedirectController {

    @Value("${app.itemsOnPage}")
    public static int itemsOnPage;

    @Autowired
    AdvertDao advertDao;

    @RequestMapping(value = "/adverts", method = RequestMethod.GET)
    public String goToAdverts(ModelMap model) {
        model.addAttribute("adverts", advertDao.findRange(1, itemsOnPage));
        model.addAttribute("page", 1);
        return "advert_list";
    }

    @RequestMapping(value = "/gotoadd", method = RequestMethod.GET)
    public String goToPage(@ModelAttribute("advert") Advert advert, ModelMap model) {
        model.addAttribute("sectionValues", Section.values());
        model.addAttribute("operationValues", Operation.values());
        return "add_advert";
    }
}