package com.epam.adzhiametov.enumeration;

/**
 * Created by Arsen Adzhiametov on 7/31/13.
 */
public enum Section {
    COMPUTERS("Computers"),
    HOUSES("Houses"),
    CARS("Cars");

    private String value;

    private Section(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
