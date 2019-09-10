package com.hospital.hospital.controller;

import com.hospital.hospital.model.Appointment;
import com.hospital.hospital.service.AppointmentService;
import com.hospital.hospital.service.DoctorService;
import com.hospital.hospital.validator.DoctorIdShouldExistValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
public class AppointmentController {

    @Autowired
    AppointmentService appointmentService;


    @GetMapping("/appointmentSample")
    Appointment getAppointmentSample() {
        Appointment appointment = new Appointment();
        appointment.setAppointmentId(1);
        appointment.setCause("broken heart");
        appointment.setDoctorId(31);
        appointment.setPatientId(25);

        SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
        try {
            Date date = sdf.parse("31-08-1982 10:20:56");
            appointment.setStartTime(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        try {
            Date date = sdf.parse("31-08-1982 11:20:56");
            appointment.setEndTime(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return appointment;
    }

    @GetMapping("/appointments")
    List<Appointment> getAllAppointments() {
        return appointmentService.getAllAppointments();
    }

    @PostMapping("appointment/save")
    void saveAppointment(@Valid @RequestBody Appointment appointment) {
        appointmentService.addAppointment(appointment);
    }

    @GetMapping("/appointment/{id}")
    Appointment getAppointmentById(@PathVariable Integer id) {
        return appointmentService.getAppointmentById(id);
    }


    @DeleteMapping(value = "/appointment/delete/{id}")
    public void deleteAppointment(@PathVariable Integer id) {
        appointmentService.deleteAppointment(id);
    }

}
