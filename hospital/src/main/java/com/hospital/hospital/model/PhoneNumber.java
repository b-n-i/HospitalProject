package com.hospital.hospital.model;

import com.hospital.hospital.validator.PhoneNumberConstraint;

public class PhoneNumber {

    @PhoneNumberConstraint
    private String phoneNumber;

    public PhoneNumber() {
    }

    public PhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
