package com.epam.adzhiametov.controller;

import com.epam.adzhiametov.dao.AdvertDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import static com.epam.adzhiametov.controller.RedirectController.ITEMS_ON_PAGE;

/**
 * Created by Arsen Adzhiametov on 7/31/13.
 */
@Controller
public class AdvertsListController {

    @Autowired
    AdvertDao advertDao;

    @RequestMapping(value = "/viewdetail/{advertId}", method = RequestMethod.GET)
    public String viewDetail(@PathVariable("advertId") String advertId, Model model) {
        model.addAttribute("advertDetail", advertDao.read(Long.valueOf(advertId)));
        return "advert_details";
    }

    @RequestMapping(value = "/paging/{page}", method = RequestMethod.GET)
    public String nextPage(@PathVariable("page") Integer page, Model model) {
        model.addAttribute("adverts", advertDao.findRange(page, ITEMS_ON_PAGE));
        model.addAttribute("page", page);
        return "advert_list";
    }
}
