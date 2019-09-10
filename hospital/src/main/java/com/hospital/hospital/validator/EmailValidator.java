package com.hospital.hospital.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class EmailValidator implements
        ConstraintValidator<EmailConstraint, String> {

    String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";

    Pattern pattern = Pattern.compile(regex);

    @Override
    public void initialize(EmailConstraint email) {
    }

    @Override
    public boolean isValid(String emailField,
                           ConstraintValidatorContext cxt) {
        System.out.println("A ajuns in email validator!");
        return emailField != null && pattern.matcher(emailField).matches();
    }

}
