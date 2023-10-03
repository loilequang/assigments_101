package com.assignment.constants;

import org.springframework.http.HttpStatus;

public enum ApiErrorCode {
    STRING_EMPTY(HttpStatus.BAD_REQUEST, "E0001", "String empty"),
    STRING_INCORRECT_VALUE(HttpStatus.BAD_REQUEST, "E0002", "INCORRECT_VALUE"),
    STRING_MAX_LENGTH(HttpStatus.BAD_REQUEST, "E0003", "String incorrect max length. Length must less than [%s]"),
    STRING_MIN_LENGTH(HttpStatus.BAD_REQUEST, "E0004", "String incorrect min length. Length must more than [%s]"),
    STRING_PATTERN(HttpStatus.BAD_REQUEST, "E0005", "String incorrect pattern"),
    NUMBER_INCORRECT_VALUE(HttpStatus.BAD_REQUEST, "E0006", "Number incorrect value"),
    NUMBER_MAX(HttpStatus.BAD_REQUEST, "E0007", "Number incorrect max value"),
    NUMBER_MIN(HttpStatus.BAD_REQUEST, "E0008", "Number incorrect min value"),
    NUMBER_INCORRECT_RANGE(HttpStatus.BAD_REQUEST, "E0009", "Number incorrect range value. Value must in [%s,%s]"),
    NUMBER_INCORRECT_TYPE(HttpStatus.BAD_REQUEST, "E0010", "String empty"),
    DATE_INCORRECT_VALUE(HttpStatus.BAD_REQUEST, "E0011", "Date incorrect"),
    NOT_FOUND(HttpStatus.NOT_FOUND, "E0404", "Api not found"),
    UNKNOW(HttpStatus.INTERNAL_SERVER_ERROR, "999", "INTERNAL_SERVER_ERROR"),
    ;

    private HttpStatus status;
    private String code;
    private String message;

    ApiErrorCode(HttpStatus status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
