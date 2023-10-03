package com.assignment.valid;

import com.assignment.valid.impl.DatePatternImpl;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = DatePatternImpl.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface DatePattern {
    String message() default "Invalid String value";

    String fieldName();

    String pattern();

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
