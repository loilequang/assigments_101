package com.assignment.valid;

import com.assignment.valid.impl.NumberRangeImpl;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = NumberRangeImpl.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface NumberRange {
    String message() default "Invalid String value";

    String fieldName();

    long max();

    long min();

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
