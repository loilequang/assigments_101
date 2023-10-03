package com.assignment.constants;

public enum OrderStatus {
    NEW("NEW"),
    CANCEL("CANCEL"),
    DELIVERING("DELIVERING"),
    DELIVER_COMPLETE("DELIVER_COMPLETE"),
    COMPLETE("COMPLETE"),
    QUEUE("QUEUE");

    OrderStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }


    private String value;
}
