package com.assignment.valid.impl;

import com.assignment.constants.ApiErrorCode;
import com.assignment.error.ApiException;
import com.assignment.utils.ApiStringUtils;
import com.assignment.valid.StringMinLength;
import lombok.extern.slf4j.Slf4j;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class StringMinLengthImpl implements ConstraintValidator<StringMinLength, String> {

    private String fieldName;
    private int min;

    @Override
    public void initialize(StringMinLength input) {
        fieldName = input.fieldName();
        min = input.min();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        if (!ApiStringUtils.isEmpty(value) && value.length() < min) {
            log.error("StringMinLength check {} error", fieldName);
            List<String> params = new ArrayList<>();
            params.add("" +min);
            throw new ApiException(ApiErrorCode.STRING_MIN_LENGTH, fieldName,params);
        }
        return true;
    }
}
