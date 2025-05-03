package org.example.service;

public enum Currency {
    EU("EU"), US("US"), RUB("RUB");

    private final String value;

    Currency(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
