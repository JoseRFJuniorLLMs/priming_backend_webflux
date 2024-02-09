package com.priming.reactive.enums;

public enum Status {
    ACTIVE("ACTIVE"), INACTIVE("INACTIVE");

    private final String value;

    Status(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value; // required for @ValueOfEnum
    }
}

