package com.epam.adzhiametov.controller;

/**
 * Created by Arsen Adzhiametov on 7/31/13.
 */
public class MVCConstants {
    private MVCConstants() {
    }

    //PathVariables
    public static final String ADVERT_ID = "advertId";
    public static final String PAGE = "page";
    public static final String PHONE = "phone";

    //Requests
    public static final String REQUEST_ADVERTS_LIST = "/adverts";
    public static final String REQUEST_GOTO_ADD_ADVERT = "/gotoadd";
    public static final String REQUEST_ADD_ADVERT = "/addadvert";
    public static final String REQUEST_VIEW_DETAIL = "/viewdetail/{" + ADVERT_ID + "}";
    public static final String REQUEST_VIEW_DETAIL_TEST = "/viewdetail/30";
    public static final String REQUEST_PAGE = "/paging/{" + PAGE + "}";
    public static final String REQUEST_PAGE_TEST = "/paging/1";
    public static final String REQUEST_ALL_OF_AUTHOR = "/thisauthor/{" + PHONE + "}";
    public static final String REQUEST_ALL_OF_AUTHOR_TEST = "/thisauthor/+380955917333";


    //Pages
    public static final String PAGE_ADVERTS_LIST = "advert_list";
    public static final String PAGE_ADD_ADVERT = "add_advert";
    public static final String PAGE_ADVERT_DETAILS = "advert_details";

    //Attributes
    public static final String ATTRIBUTE_ADVERTS = "adverts";
    public static final String ATTRIBUTE_ADVERT = "advert";
    public static final String ATTRIBUTE_PAGE = "page";
    public static final String ATTRIBUTE_SECTIONS = "sectionValues";
    public static final String ATTRIBUTE_OPERATIONS = "operationValues";
    public static final String ATTRIBUTE_ADVERT_DETAIL = "advertDetail";

    //Page parameters
    public static final int ITEMS_ON_PAGE = 5;
    public static final int FIRST_PAGE = 1;
}
