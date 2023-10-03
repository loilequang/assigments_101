package com.assignment.utils;

public class ApiStringUtils {
    private ApiStringUtils() {
    }

    public static boolean isEmpty(String value) {
        return null == value || value.length() < 1;
    }
}
