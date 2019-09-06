package com.hospital.hospital.model;

import com.hospital.hospital.validator.EmailConstraint;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="emails")
public class Email {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="email_id")
    private Integer emailId;
    @NotNull
    @EmailConstraint
    @Column(name="email")
    private String email;

    public  Email(){

    }

    public Email( @NotNull String email) {
        this.email = email;
    }

    public Integer getEmailId() {
        return emailId;
    }

    public void setEmailId(Integer emailId) {
        this.emailId = emailId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
