package com.assignment.valid.impl;

import com.assignment.constants.ApiErrorCode;
import com.assignment.error.ApiException;
import com.assignment.valid.FieldNotNull;
import lombok.extern.slf4j.Slf4j;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Slf4j
public class FieldNotNullImpl implements ConstraintValidator<FieldNotNull, Object> {

    private String fieldName;

    @Override
    public void initialize(FieldNotNull input) {
        fieldName = input.fieldName();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        if ( value == null) {
            log.error("FieldNotNull check {} error", fieldName);
            throw new ApiException(ApiErrorCode.STRING_EMPTY, fieldName);
        }
        return true;
    }
}
