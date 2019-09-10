package com.hospital.hospital.validator;

import com.hospital.hospital.model.Appointment;
import com.hospital.hospital.repository.PatientRepository;

import javax.annotation.Resource;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AppointmentValidator implements
        ConstraintValidator<AppointmentConstraint, Appointment> {


    @Override
    public void initialize(AppointmentConstraint appointment) {
    }

    @Override
    public boolean isValid(Appointment appointment,
                           ConstraintValidatorContext cxt) {
        System.out.println("A ajuns in appointment validator!");
        return appointment.getStartTime().before(appointment.getEndTime()) &&
                appointment.getEndTime().after(appointment.getStartTime());
    }
}
