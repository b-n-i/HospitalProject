package com.hospital.hospital.validator;

import com.hospital.hospital.repository.DoctorRepository;
import com.hospital.hospital.service.BeanUtil;
import com.hospital.hospital.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

//posible solutions:
//https://medium.com/@ssscripting/getting-autowired-fields-to-work-with-constraintvalidators-in-spring-boot-74424d5b0aaa
//https://docs.spring.io/spring/docs/4.2.4.RELEASE/spring-framework-reference/html/validation.html

//https://www.logicbig.com/tutorials/spring-framework/spring-core/creating-custom-validation-constraints.html

@Configurable(autowire = Autowire.BY_TYPE, dependencyCheck = true)
public class DoctorIdShouldExistValidator implements
        ConstraintValidator<DoctorIdShouldExistConstraint, Integer> {

    @Autowired
    DoctorRepository doctorRepository;

    public DoctorIdShouldExistValidator() { }

    @Override
    public void initialize(DoctorIdShouldExistConstraint doctorId) {
        doctorRepository = BeanUtil.getBean(DoctorRepository.class);
    }

    @Override
    public boolean isValid(Integer doctorId,
                           ConstraintValidatorContext cxt) {
        System.out.println("A ajuns in doctorId validator!");
        return doctorRepository.findById(doctorId).isPresent();
    }
}
