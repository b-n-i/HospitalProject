package com.hospital.hospital.validator;

import com.hospital.hospital.repository.PatientRepository;
import com.hospital.hospital.service.IPatientService;
import com.hospital.hospital.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class PatientIdShouldExistValidator implements
        ConstraintValidator<PatientIdShouldExistConstraint, Integer> {

    @Autowired
    PatientService patientService;

    @Override
    public void initialize(PatientIdShouldExistConstraint patientId) {
    }

    @Override
    public boolean isValid(Integer patientId,
                           ConstraintValidatorContext cxt) {
        System.out.println("A ajuns in patientId validator!");
        return patientService.getPatientById(patientId)!=null;
    }
}
