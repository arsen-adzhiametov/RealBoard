package com.epam.adzhiametov.util;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Arsen Adzhiametov on 7/31/13.
 */
public class ValidationHelper {

    private static final String NAME_PATTERN = "^[а-яa-z]{3,10}$";
    private static final String PHONE_PATTERN = "^[+][1-9][0-9]{11}$";
    private static final String PRICE_PATTERN = "^[0-9]{0,7}\\.?[0-9]{1,2}$";

    public static boolean isNameValid(String name){
        Pattern pattern = Pattern.compile(NAME_PATTERN);
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
    }

    public static boolean isPhoneValid(String phone){
        Pattern pattern = Pattern.compile(PHONE_PATTERN);
        Matcher matcher = pattern.matcher(phone);
        return matcher.matches();
    }

    public static boolean isPriceValid(BigDecimal price){
        if (price == null) return false;
        Pattern pattern = Pattern.compile(PRICE_PATTERN);
        Matcher matcher = pattern.matcher(price.toString());
        return matcher.matches();
    }

}
