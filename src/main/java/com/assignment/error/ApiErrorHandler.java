package com.assignment.error;

import com.assignment.response.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiErrorHandler {
    @ExceptionHandler(ApiException.class)
    public ResponseEntity handlerApiError(ApiException error) {
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setCode(error.getErrorCode().getCode());;
        apiResponse.setMessage(error.getErrorCode().getMessage());
        return new ResponseEntity(apiResponse, error.getErrorCode().getStatus());
    }
}
