package com.hospital.hospital.controller;

import com.hospital.hospital.model.Appointment;
import org.junit.Test;

import static org.junit.Assert.*;

public class AppointmentControllerTest {

    @Test
    public void getAppointmentSample() {
        AppointmentController appointmentController = new AppointmentController();
        Appointment result = appointmentController.getAppointmentSample();
        assertEquals(1, (int) result.getAppointmentId());
    }
}