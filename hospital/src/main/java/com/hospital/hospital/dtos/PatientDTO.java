package com.hospital.hospital.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hospital.hospital.model.Address;
import com.hospital.hospital.model.Email;
import com.hospital.hospital.model.Patient;
import com.hospital.hospital.model.PhoneNumber;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

// Resources:
// http://progressivecoder.com/rest-api-using-spring-boot-insert-update/
//https://auth0.com/blog/automatically-mapping-dto-to-entity-on-spring-boot-apis/
//https://www.baeldung.com/entity-to-and-from-dto-for-a-java-spring-application
public class PatientDTO {
    private Integer id;

    @JsonIgnore
    private String firstName;

    @JsonIgnore
    private String lastName;

    private Integer age;

    private Address address;
    @Valid
    private Email email;
    @Valid
    private PhoneNumber phoneNumber;

    @JsonIgnore
    private List<String> fieldsToBeUpdated;

    public PatientDTO() {
        fieldsToBeUpdated = new ArrayList<>();
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
        fieldsToBeUpdated.add("Age");
        this.age = age;
    }


    public Address getAddress() {
        return address;
    }


    public void setAddress(Address address) {
        fieldsToBeUpdated.add("Address");
        this.address = address;
    }


    public Email getEmail() {
        return email;
    }


    public void setEmail(Email email) {
        fieldsToBeUpdated.add("Email");
        this.email = email;
    }


    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }


    public void setPhoneNumber(PhoneNumber phoneNumber) {
        fieldsToBeUpdated.add("PhoneNumber");
        this.phoneNumber = phoneNumber;
    }

    public List<String> getFieldsToBeUpdated() {
        return fieldsToBeUpdated;
    }
}
