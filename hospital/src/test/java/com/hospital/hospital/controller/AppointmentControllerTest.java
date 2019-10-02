package com.hospital.hospital.controller;

import com.hospital.hospital.model.Appointment;
import org.junit.Test;

import static org.junit.Assert.*;

//RESOURCES
//https://www.youtube.com/watch?v=8S8o46avgAw
//https://reflectoring.io/unit-testing-spring-boot/
//https://reflectoring.io/spring-boot-web-controller-test/
//https://github.com/hellokoding/hellokoding-courses/blob/master/springboot-examples/springboot-restapi-testing-all-layers/src/test/java/com/hellokoding/springboot/restful/product/ProductServiceTest.java

public class AppointmentControllerTest {

    @Test
    public void getAppointmentSample() {
        AppointmentController appointmentController = new AppointmentController();
        Appointment result = appointmentController.getAppointmentSample();
        assertEquals(1, (int) result.getAppointmentId());
    }
}