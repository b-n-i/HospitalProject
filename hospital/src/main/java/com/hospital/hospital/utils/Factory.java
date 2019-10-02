package com.hospital.hospital.utils;

import com.hospital.hospital.model.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Factory {

    public static Address getAddressSample(){
        Address address = new Address();
        address.setCity("city");
        address.setCountry("country");
        address.setStreet("street");
        address.setStreetNumber("street_number");
        return  address;
    }

    public static Email getEmailSample(){
        Email email = new Email();
        email.setEmail("email");
        return email;
    }

    public static Appointment getAppointmentSample(){
        Appointment appointment = new Appointment();
        appointment.setAppointmentId(1);
        appointment.setCause("broken heart");
        appointment.setDoctorId(31);
        appointment.setPatientId(25);

        SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
        try {
            Date date = sdf.parse("31-08-2022 10:20:56");
            appointment.setStartTime(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        try {
            Date date = sdf.parse("31-08-2022 11:20:56");
            appointment.setEndTime(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return appointment;
    }

    public static PhoneNumber getPhoneNumberSample(){
        PhoneNumber phoneNumber = new PhoneNumber();
        phoneNumber.setPhoneNumber("phone_number");
        return  phoneNumber;
    }

    public static Doctor getDoctorSample(){
        Email email = getEmailSample();
        Address address = getAddressSample();
        PhoneNumber phoneNumber = getPhoneNumberSample();

        Doctor doctor = new Doctor();
        doctor.setFirstName("first_name");
        doctor.setLastName("last_name");
        doctor.setFunction("function");
        doctor.setEmail(email);
        doctor.setAddress(address);
        doctor.setPhoneNumber(phoneNumber);

        return  doctor;
    }
}
