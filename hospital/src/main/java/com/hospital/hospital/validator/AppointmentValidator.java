package com.hospital.hospital.validator;

import com.hospital.hospital.model.Appointment;
import com.hospital.hospital.repository.AppointmentRepository;
import com.hospital.hospital.repository.PatientRepository;
import com.hospital.hospital.service.AppointmentService;
import com.hospital.hospital.service.BeanUtil;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

import javax.annotation.Resource;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

//@Configurable(autowire = Autowire.BY_TYPE, dependencyCheck = true)
public class AppointmentValidator implements
        ConstraintValidator<AppointmentConstraint, Appointment> {

    @Autowired
    AppointmentRepository appointmentRepository;

    @Override
    public void initialize(AppointmentConstraint appointment) {
        appointmentRepository = BeanUtil.getBean(AppointmentRepository.class);
    }

    @Override
    public boolean isValid(Appointment appointment,
                           ConstraintValidatorContext cxt) {
        System.out.println("A ajuns in appointment validator!");
        boolean intervalIsOk = appointmentRepository.getAppointmentsFromInterval(appointment.getStartTime(), appointment.getEndTime()).isEmpty();
        System.out.println(intervalIsOk);
        return appointment.getStartTime().before(appointment.getEndTime()) &&
                appointment.getEndTime().after(appointment.getStartTime())&&intervalIsOk;
    }
}
