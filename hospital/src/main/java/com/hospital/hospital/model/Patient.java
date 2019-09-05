package com.hospital.hospital.model;

import javax.validation.Valid;

//firstName - String
//lastName – String
//age - int
//Address – Object
//Email – Object – make sure the email is valid
//PhoneNumber – Object – the phone number should be validated (criterias : only digits, length of 10, starts with 07)
public class Patient {

    private Integer id;
    private String firstName;
    private String lastName;
    private Integer age;
    private Address address;
    @Valid
    private Email email;
    @Valid
    private PhoneNumber phoneNumber;

    public Patient(){

    }

    public Patient(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(PhoneNumber phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
