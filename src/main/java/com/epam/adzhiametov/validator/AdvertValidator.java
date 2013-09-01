package com.epam.adzhiametov.validator;

import com.epam.adzhiametov.model.Advert;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import static com.epam.adzhiametov.util.ValidationHelper.*;

/**
 * Created by Arsen Adzhiametov on 7/31/13.
 */
@Component
public class AdvertValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return Advert.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Advert advert = (Advert) o;
        if (!isNameValid(advert.getName())) {
            errors.rejectValue("name", "error", "not matches");
        }
        if (!isPhoneValid(advert.getPhone())) {
            errors.rejectValue("phone", "error", "not matches");
        }
        if (advert.getContract() == false) {
            if (!isPriceValid(advert.getPrice())) {
                errors.rejectValue("price", "error", "not matches");
            }
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "text", "error", "Field is required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "error", "Field is required");
    }
}
