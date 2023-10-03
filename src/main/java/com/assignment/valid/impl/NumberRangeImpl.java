package com.assignment.valid.impl;

import com.assignment.constants.ApiErrorCode;
import com.assignment.error.ApiException;
import com.assignment.valid.NumberRange;
import lombok.extern.slf4j.Slf4j;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class NumberRangeImpl implements ConstraintValidator<NumberRange, Object> {

    private String fieldName;
    private long max;
    private long min;

    @Override
    public void initialize(NumberRange input) {
        fieldName = input.fieldName();
        max = input.max();
        min = input.min();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        if(value != null){
            long valueLong  = Long.parseLong(value.toString());
            if (valueLong< min || valueLong> max) {
                log.error("NumberRange check {} error", fieldName);
                List<String> params = new ArrayList<>();
                params.add("" + min);
                params.add("" + max);
                throw new ApiException(ApiErrorCode.NUMBER_INCORRECT_RANGE, fieldName,params);
            }
        }

        return true;
    }
}
