package com.hospital.hospital.service;

import com.hospital.hospital.model.Appointment;
import com.hospital.hospital.repository.AppointmentRepository;
import com.hospital.hospital.utils.Factory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;

@RunWith(MockitoJUnitRunner.class)
public class AppointmentServiceTest {

    @Mock
    private AppointmentRepository appointmentRepository;

    @InjectMocks
    private AppointmentService appointmentService;

//    @Before ---> UTILIZAT IN LOC DE ADNOTAREA RUNWITH
//    public void init() {
//        MockitoAnnotations.initMocks(this);
//    }

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

    @Test
    public void testGetAllAppointmentsThenReturnAppointmentList() {
// we tell the repository method what to return and then the service will call that method

        // given
        Appointment appointment = Factory.getAppointmentSample();
        List<Appointment> expectedAppointments = Arrays.asList(appointment);

        doReturn(expectedAppointments).when(appointmentRepository).findAll();

        // when
        List<Appointment> actualAppointments = appointmentService.getAllAppointments();

        // then
        assertThat(actualAppointments).isEqualTo(expectedAppointments);
    }

}