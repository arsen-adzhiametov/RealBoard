package com.epam.adzhiametov.controller;

import com.epam.adzhiametov.dao.AdvertDao;
import com.epam.adzhiametov.enumeration.Operation;
import com.epam.adzhiametov.enumeration.Section;
import com.epam.adzhiametov.model.Advert;
import com.epam.adzhiametov.validator.AdvertValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.Calendar;

import static com.epam.adzhiametov.controller.MVCConstants.*;

/**
 * Created by Arsen Adzhiametov on 7/31/13.
 */
@Controller
public class AddAdvertController {

    @Autowired
    AdvertDao advertDao;

    @Autowired
    AdvertValidator advertValidator;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(advertValidator);
    }

    @RequestMapping(value = REQUEST_ADD_ADVERT, method = RequestMethod.POST)
    public String addAdvert(@Valid @ModelAttribute(ATTRIBUTE_ADVERT) Advert advert, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute(ATTRIBUTE_SECTIONS, Section.values());
            model.addAttribute(ATTRIBUTE_OPERATIONS, Operation.values());
            return PAGE_ADD_ADVERT;
        }
        advert.setTime(Calendar.getInstance());
        advertDao.create(advert);
        model.addAttribute(ATTRIBUTE_ADVERTS, advertDao.findRange(FIRST_PAGE, ITEMS_ON_PAGE));
        model.addAttribute(ATTRIBUTE_PAGE, FIRST_PAGE);
        return PAGE_ADVERTS_LIST;
    }

}
