package com.hospital.hospital.validator;

import com.hospital.hospital.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

//posible solutions:
//https://medium.com/@ssscripting/getting-autowired-fields-to-work-with-constraintvalidators-in-spring-boot-74424d5b0aaa
//https://docs.spring.io/spring/docs/4.2.4.RELEASE/spring-framework-reference/html/validation.html
@Component
public class DoctorIdShouldExistValidator implements
        ConstraintValidator<DoctorIdShouldExistConstraint, Integer> {

    @Autowired
    DoctorService doctorService;

    public DoctorIdShouldExistValidator(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @Override
    public void initialize(DoctorIdShouldExistConstraint doctorId) {
    }

    @Override
    public boolean isValid(Integer doctorId,
                           ConstraintValidatorContext cxt) {
        System.out.println("A ajuns in doctorId validator!");
        return doctorService.getDoctorById(doctorId)!=null;
    }
}
