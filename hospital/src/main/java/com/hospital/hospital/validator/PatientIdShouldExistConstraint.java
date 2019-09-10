package com.hospital.hospital.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PatientIdShouldExistValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface PatientIdShouldExistConstraint {
    String message() default "PatientId does not exist";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
