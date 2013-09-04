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

import static com.epam.adzhiametov.controller.RedirectController.itemsOnPage;

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

    @RequestMapping(value = "/addadvert", method = RequestMethod.POST)
    public String addAdvert(@Valid @ModelAttribute("advert") Advert advert, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("sectionValues", Section.values());
            model.addAttribute("operationValues", Operation.values());
            return "add_advert";
        }
        advert.setTime(Calendar.getInstance());
        advertDao.create(advert);
        model.addAttribute("adverts", advertDao.findRange(1, itemsOnPage));
        model.addAttribute("page", 1);
        return "advert_list";
    }

}
