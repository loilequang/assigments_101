package com.assignment.valid;

import com.assignment.valid.impl.NumberMinImpl;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = NumberMinImpl.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface NumberMin {
    String message() default "Invalid String value";

    String fieldName();
    long min();

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
