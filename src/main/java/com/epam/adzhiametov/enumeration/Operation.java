package com.epam.adzhiametov.enumeration;

/**
 * Created by Arsen Adzhiametov on 7/31/13.
 */
public enum Operation {
    BUY("Buy"),
    SALE("Sale"),
    GIFT("Gift");

    private String value;

    private Operation(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
