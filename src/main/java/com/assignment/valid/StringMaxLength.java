package com.assignment.valid;

import com.assignment.valid.impl.StringMaxLengthImpl;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = StringMaxLengthImpl.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface StringMaxLength {
    String message() default "Invalid String value";

    String fieldName();

    int max();

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
