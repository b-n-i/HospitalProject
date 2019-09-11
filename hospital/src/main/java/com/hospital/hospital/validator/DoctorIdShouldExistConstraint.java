package com.hospital.hospital.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = DoctorIdShouldExistValidator.class)
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER,
        ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface DoctorIdShouldExistConstraint {
    String message() default "DoctorId does not exist";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
