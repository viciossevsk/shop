package com.shop.SV_TASK.otherFunction;

public class AddvansedFunctions {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";

    public static String stringToGreenColor(String text) {
        return ANSI_GREEN + text + ANSI_RESET;
    }

    public static String stringToRedColor(String text) {
        return ANSI_RED + text + ANSI_RESET;
    }

    public static final String MISTAKEN_PRODUCT_ID = "Mistaken Product id: %s";
    public static final String MISTAKEN_SUPPLIER_ID = "Mistaken Supplier id: %s";
    public static final String MISTAKEN_SUPPLY_ID = "Mistaken supply id: %s";
    public static final String MISTAKEN_PRODUCT_PRICE_ID = "Mistaken Product price id: %s";
    public static final String MISTAKEN_VALID_SUPPLY_NUM = "Supply number %s already exists";
}
