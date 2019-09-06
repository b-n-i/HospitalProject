package com.hospital.hospital.model;

import javax.persistence.*;
import javax.validation.Valid;

//firstName - String
//lastName – String
//age - int
//Address – Object
//Email – Object – make sure the email is valid
//PhoneNumber – Object – the phone number should be validated (criterias : only digits, length of 10, starts with 07)
@Entity
@Table(name="patients")
public class Patient {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="doctor_id")
    private Integer id;
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    @Column(name="age")
    private Integer age;
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "address_id")
    private Address address;
    @Valid
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "email_id")
    private Email email;
    @Valid
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "phone_number_id")
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
