package com.assignment.valid.impl;

import com.assignment.constants.ApiErrorCode;
import com.assignment.error.ApiException;
import com.assignment.valid.NumberMin;
import lombok.extern.slf4j.Slf4j;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class NumberMinImpl implements ConstraintValidator<NumberMin, Object> {

    private String fieldName;

    private long min;

    @Override
    public void initialize(NumberMin input) {
        fieldName = input.fieldName();
        min = input.min();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        if(value != null){
            long valueLong  = Long.parseLong(value.toString());
            if (valueLong< min  ) {
                log.error("NumberRange check {} error", fieldName);
                List<String> params = new ArrayList<>();
                params.add("" + min);
                throw new ApiException(ApiErrorCode.NUMBER_INCORRECT_RANGE, fieldName,params);
            }
        }

        return true;
    }
}
