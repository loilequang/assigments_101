package com.assignment.valid.impl;

import com.assignment.constants.ApiErrorCode;
import com.assignment.error.ApiException;
import com.assignment.valid.NumberMax;
import lombok.extern.slf4j.Slf4j;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class NumberMaxImpl implements ConstraintValidator<NumberMax, Object> {

    private String fieldName;
    private long max;


    @Override
    public void initialize(NumberMax input) {
        fieldName = input.fieldName();
        max = input.max();

    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        if(value != null){
            long valueLong  = Long.parseLong(value.toString());
            if (  valueLong> max) {
                log.error("NumberRange check {} error", fieldName);
                List<String> params = new ArrayList<>();

                params.add("" + max);
                throw new ApiException(ApiErrorCode.NUMBER_INCORRECT_RANGE, fieldName,params);
            }
        }

        return true;
    }
}
