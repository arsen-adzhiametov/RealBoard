package com.epam.adzhiametov.controller;

import com.epam.adzhiametov.dao.AdvertDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import static com.epam.adzhiametov.controller.MVCConstants.*;

/**
 * Created by Arsen Adzhiametov on 7/31/13.
 */
@Controller
public class AdvertsListController {

    @Autowired
    AdvertDao advertDao;

    @RequestMapping(value = REQUEST_VIEW_DETAIL, method = RequestMethod.GET)
    public String viewDetail(@PathVariable(ADVERT_ID) String advertId, Model model) {
        model.addAttribute(ATTRIBUTE_ADVERT_DETAIL, advertDao.read(Long.valueOf(advertId)));
        return PAGE_ADVERT_DETAILS;
    }

    @RequestMapping(value = REQUEST_PAGE, method = RequestMethod.GET)
    public String nextPage(@PathVariable(PAGE) Integer page, Model model) {
        model.addAttribute(ATTRIBUTE_ADVERTS, advertDao.findRange(page, ITEMS_ON_PAGE));
        model.addAttribute(ATTRIBUTE_PAGE, page);
        return PAGE_ADVERTS_LIST;
    }
}
