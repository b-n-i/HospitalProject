package com.hospital.hospital.controller;

import com.hospital.hospital.model.Appointment;
import com.hospital.hospital.model.Doctor;
import com.hospital.hospital.model.Email;
import com.hospital.hospital.model.Patient;
import com.hospital.hospital.service.AppointmentService;
import com.hospital.hospital.service.DoctorService;
import com.hospital.hospital.service.EmailServiceImpl;
import com.hospital.hospital.service.PatientService;
import com.hospital.hospital.utils.DateTimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    @Autowired
    AppointmentService appointmentService;

    @Autowired
    EmailServiceImpl emailService;

    @Autowired
    PatientService patientService;

    @Autowired
    DoctorService doctorService;


    @GetMapping("/sample")
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

    @GetMapping("/list")
    List<Appointment> getAllAppointments() {
        return appointmentService.getAllAppointments();
    }

    @PostMapping("/save")
    void saveAppointment(@Valid @RequestBody Appointment appointment) {
        appointmentService.addAppointment(appointment);

        String appointmentDate = DateTimeUtils.getStringDateWithoutTime(appointment.getStartTime());
        String startTime = DateTimeUtils.getStringTimeWithoutDate(appointment.getStartTime());
        String endTime = DateTimeUtils.getStringTimeWithoutDate(appointment.getEndTime());

//  notify doctor and patient via email
        Patient patient = patientService.getPatientById(appointment.getPatientId());
        Doctor doctor = doctorService.getDoctorById(appointment.getDoctorId());
        emailService.sendAppointmentMessageToPatient(patient, doctor, appointment, appointmentDate, startTime, endTime);
        emailService.sendAppointmentMessageToDoctor(patient, doctor, appointment, appointmentDate, startTime, endTime);
    }

    @GetMapping("/{id}")
    Appointment getAppointmentById(@PathVariable Integer id) {
        return appointmentService.getAppointmentById(id);
    }


    @DeleteMapping(value = "/delete/{id}")
    public void deleteAppointment(@PathVariable Integer id) {
        appointmentService.deleteAppointment(id);
    }

    @GetMapping(value = "/doctor/{id}")
    public List<Appointment> getAppointmentsByDoctorId(@PathVariable Integer id) {
        return appointmentService.getAppointmentsByDoctorId(id);
    }


    @GetMapping(value = "/patient/{id}")
    public List<Appointment> getAppointmentsByPatientId(@PathVariable Integer id) {
        return appointmentService.getAppointmentsByPatientId(id);
    }

    @GetMapping(value = "/past/doctor/{id}")
    public List<Appointment> getAppointmentByDoctorIdFindByStartDateBeforeCurrentDate(@PathVariable Integer id) {
        Date currentDate = new Date(System.currentTimeMillis());
        return appointmentService.getAppointmentsDoctorIdBeforeDate(id, currentDate);
    }

    @GetMapping(value = "/future")
    public List<Appointment> getAppointmentInTheFuture() {
        Date currentDate = new Date(System.currentTimeMillis());
        return appointmentService.getAppointmentAfterDate(currentDate);
    }

    @PatchMapping(value = "/cancel/{id}")
    public Boolean cancelAppointment(@PathVariable Integer id) {
        Appointment appointmentToBeCancelled = appointmentService.getAppointmentById(id);
        Boolean response = appointmentService.canBeCancelled(appointmentToBeCancelled);
        if (response) {
            appointmentToBeCancelled.setCancelled(true);
            appointmentService.updateAppointment(appointmentToBeCancelled);
        }
        return response;
    }

    @PostMapping(value = "/test")
    public void test() {
        Doctor doctor = new Doctor();
        Email email = new Email();
        email.setEmail("bacaoanuioana@yahoo.com");

        doctor.setEmail(email);
        doctor.setFirstName("Radu");
//        emailService.sendMessageToDoctor(doctor);

        Email patientEmail = new Email();
        patientEmail.setEmail("b_nicoleta_ioana@yahoo.com");
        Patient patient = new Patient();
        patient.setFirstName("patient");
        patient.setEmail(patientEmail);

        Appointment appointment = getAppointmentSample();

        String appointmentDate = DateTimeUtils.getStringDateWithoutTime(appointment.getStartTime());
        String startTime = DateTimeUtils.getStringTimeWithoutDate(appointment.getStartTime());
        String endTime = DateTimeUtils.getStringTimeWithoutDate(appointment.getEndTime());

        emailService.sendAppointmentMessageToPatient(patient, doctor, appointment, appointmentDate, startTime, endTime);
        emailService.sendAppointmentMessageToDoctor(patient, doctor, appointment, appointmentDate, startTime, endTime);
    }
}
