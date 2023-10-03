package com.assignment.valid;

import com.assignment.valid.impl.StringMinLengthImpl;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = StringMinLengthImpl.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface StringMinLength {
    String message() default "Invalid String value";

    String fieldName();

    int min();

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
