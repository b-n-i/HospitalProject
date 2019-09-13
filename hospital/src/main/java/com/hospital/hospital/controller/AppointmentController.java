package com.hospital.hospital.controller;

import com.hospital.hospital.model.Appointment;
import com.hospital.hospital.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.system.ApplicationPid;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

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

    @GetMapping(value = "appointment/doctor/{id}")
    public List<Appointment> getAppointmentsByDoctorId(@PathVariable Integer id) {
        return appointmentService.getAppointmentsByDoctorId(id);
    }


    @GetMapping(value = "appointment/patient/{id}")
    public List<Appointment> getAppointmentsByPatientId(@PathVariable Integer id) {
        return appointmentService.getAppointmentsByPatientId(id);
    }

    @GetMapping(value = "appointment/active/doctor/{id}")
    public List<Appointment> getAppointmentByDoctorIdFindByStartDateBeforeCurrentDate(@PathVariable Integer id){
        Date currentDate = new Date(System.currentTimeMillis());
        return appointmentService.getAppointmentsDoctorIdBeforeDate(id, currentDate);
    }

    @GetMapping(value = "appointment/future")
    public List<Appointment> getAppointmentInTheFuture(){
        Date currentDate = new Date(System.currentTimeMillis());
        return appointmentService.getAppointmentAfterDate(currentDate);
    }

    @PatchMapping(value="appointments/cancel/{id}")
    public void cancelAppointment(@PathVariable Integer id){
        Appointment appointmentToBeCancelled = appointmentService.getAppointmentById(id);
        System.out.println(appointmentToBeCancelled.getStartTime());
        if( appointmentService.canBeCancelled(appointmentToBeCancelled)){
            appointmentToBeCancelled.setCancelled(true);
            appointmentService.updateAppointment(appointmentToBeCancelled);
        }
    }
}
