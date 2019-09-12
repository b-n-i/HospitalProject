package com.hospital.hospital.validator;

import com.hospital.hospital.repository.PatientRepository;
import com.hospital.hospital.service.BeanUtil;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PatientIdShouldExistValidator implements
        ConstraintValidator<PatientIdShouldExistConstraint, Integer> {

    @Autowired
    PatientRepository patientRepository;

    @Override
    public void initialize(PatientIdShouldExistConstraint patientId) {
        patientRepository = BeanUtil.getBean(PatientRepository.class);
    }

    @Override
    public boolean isValid(Integer patientId,
                           ConstraintValidatorContext cxt) {
        System.out.println("A ajuns in patientId validator!");
        return patientRepository.findById(patientId).isPresent();
    }
}
