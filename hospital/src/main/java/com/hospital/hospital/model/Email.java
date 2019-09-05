package com.hospital.hospital.model;

import com.hospital.hospital.validator.EmailConstraint;

import javax.validation.constraints.NotNull;

public class Email {
    @NotNull
    @EmailConstraint
    private String emailAddress;

    public  Email(){

    }

    public Email(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}
