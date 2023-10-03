package com.assignment.valid.impl;

import com.assignment.constants.ApiErrorCode;
import com.assignment.error.ApiException;
import com.assignment.utils.ApiDateTime;
import com.assignment.utils.ApiStringUtils;
import com.assignment.valid.DatePattern;
import lombok.extern.slf4j.Slf4j;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Date;

@Slf4j
public class DatePatternImpl implements ConstraintValidator<DatePattern, String> {

    private String fieldName;
    String pattern;

    @Override
    public void initialize(DatePattern input) {
        fieldName = input.fieldName();
        pattern = input.pattern();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (!ApiStringUtils.isEmpty(value)) {
            Date date = ApiDateTime.getDateByString(value, pattern);
            if (null == date) {
                log.error("DatePattern check {} error", fieldName);
                throw new ApiException(ApiErrorCode.DATE_INCORRECT_VALUE, fieldName);
            }
        }
        return true;
    }
}
