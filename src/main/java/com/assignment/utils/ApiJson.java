package com.assignment.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ApiJson {
    private ApiJson() {
    }

    public static String getJsonString(Object value) {
        try {
            return new ObjectMapper().writeValueAsString(value);
        } catch (Exception ex) {
            return "";
        }
    }
}
