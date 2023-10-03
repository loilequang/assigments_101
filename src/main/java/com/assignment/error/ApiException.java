package com.assignment.error;


import com.assignment.constants.ApiErrorCode;

import java.util.Collections;
import java.util.List;

public class ApiException extends RuntimeException {
    private ApiErrorCode errorCode;
    private String objectName;
    private List<String> params; // parameters for message

    public String getObjectName() {
        return objectName;
    }

    public ApiException(ApiErrorCode errorCode, String objectName) {
        this.errorCode = errorCode;
        this.objectName = objectName;
        params= Collections.EMPTY_LIST;
    }

    public ApiException(ApiErrorCode errorCode, String objectName, List<String> params) {
        this.errorCode = errorCode;
        this.objectName = objectName;
        this.params = params;
    }

    public List<String> getParams() {
        return params;
    }

    public ApiErrorCode getErrorCode() {
        return errorCode;
    }
    public ApiException(ApiErrorCode errorCode) {
        this.errorCode = errorCode;
    }


}
