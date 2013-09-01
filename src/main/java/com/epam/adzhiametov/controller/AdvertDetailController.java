package com.epam.adzhiametov.controller;

import com.epam.adzhiametov.dao.AdvertDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Arsen Adzhiametov on 7/31/13.
 */
@Controller
public class AdvertDetailController {

    @Autowired
    AdvertDao advertDao;

    @RequestMapping(value = "/thisauthor/{phone}", method = RequestMethod.GET)
    public String viewDetail(@PathVariable("phone") String phone, Model model) {
        model.addAttribute("adverts", advertDao.find(phone));
        return "advert_list";
    }
}
