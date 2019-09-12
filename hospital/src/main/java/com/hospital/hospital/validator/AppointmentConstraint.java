package com.hospital.hospital.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = AppointmentValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface AppointmentConstraint {
    String message() default "Appointment not valid";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
