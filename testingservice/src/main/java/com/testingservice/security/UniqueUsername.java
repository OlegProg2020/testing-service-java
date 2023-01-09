package com.testingservice.security;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Documented
@Constraint(validatedBy = UsernameUniqueValidator.class)
@Target(value = { ElementType.FIELD })
@Retention(value = RetentionPolicy.RUNTIME)
public @interface UniqueUsername {
    String message() default "";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
