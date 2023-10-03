package com.assignment.valid.impl;

import com.assignment.constants.ApiErrorCode;
import com.assignment.error.ApiException;
import com.assignment.utils.ApiStringUtils;
import com.assignment.valid.StringMaxLength;
import lombok.extern.slf4j.Slf4j;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class StringMaxLengthImpl implements ConstraintValidator<StringMaxLength, String> {

    private String fieldName;
    private int max;

    @Override
    public void initialize(StringMaxLength input) {
        fieldName = input.fieldName();
        max = input.max();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (!ApiStringUtils.isEmpty(value) && value.length() > max) {
            log.error("StringMaxLength check {} error", fieldName);
            List<String> params = new ArrayList<>();
            params.add("" + max);
            throw new ApiException(ApiErrorCode.STRING_MAX_LENGTH, fieldName,params);

        }
        return true;
    }
}
