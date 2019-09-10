package com.hospital.hospital.service;

import com.hospital.hospital.model.Appointment;

import java.util.List;

public interface IAppointmentService {
    List<Appointment> getAllAppointments();

    Appointment getAppointmentById(Integer appointmentId);

    void addAppointment(Appointment appointment);

    void deleteAppointment(Integer appointmentId);
}
