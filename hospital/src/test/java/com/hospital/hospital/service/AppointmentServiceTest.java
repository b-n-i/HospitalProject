package com.hospital.hospital.service;

import com.hospital.hospital.model.Appointment;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertFalse;

public class AppointmentServiceTest {

    @InjectMocks
    private AppointmentService appointmentService;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAppointmentThatTookPlaceCanNotBeCancelled() {
            Appointment appointment = new Appointment();

        appointment.setTookPlace(true);

        Boolean result = appointmentService.canBeCancelled(appointment);

        assertFalse(result);
    }

    @Test
    public void testAppointmentCanNotBeCancelledOneHourBeforeStartTime() {
        Appointment appointment = new Appointment();

        appointment.setStartTime(new Date(System.currentTimeMillis()));

        Boolean result = appointmentService.canBeCancelled(appointment);

        assertFalse(result);
    }

}