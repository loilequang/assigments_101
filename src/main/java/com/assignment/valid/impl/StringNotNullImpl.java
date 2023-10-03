package com.assignment.valid.impl;

import com.assignment.constants.ApiErrorCode;
import com.assignment.error.ApiException;
import com.assignment.utils.ApiStringUtils;
import com.assignment.valid.StringNotNull;
import lombok.extern.slf4j.Slf4j;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Slf4j
public class StringNotNullImpl implements ConstraintValidator<StringNotNull, String> {

    private String fieldName;

    @Override
    public void initialize(StringNotNull input) {
        fieldName = input.fieldName();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (ApiStringUtils.isEmpty(value)) {
            log.error("StringNotNull check {} error", fieldName);
            throw new ApiException(ApiErrorCode.STRING_EMPTY, fieldName);
        }
        return true;
    }
}
