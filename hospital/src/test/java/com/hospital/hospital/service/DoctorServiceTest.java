package com.hospital.hospital.service;

import com.hospital.hospital.model.Doctor;
import com.hospital.hospital.repository.DoctorRepository;
import com.hospital.hospital.utils.Factory;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.Assert.*;

public class DoctorServiceTest {

    @Mock
    private DoctorRepository doctorRepository;

    @InjectMocks
    private DoctorService doctorService;

    @Test
    public void updateDoctor() {
//        https://dennis.bloggingabout.net/2011/09/15/how-to-unit-test-a-method-that-has-void-as-return-type/
        Doctor doctor = Factory.getDoctorSample();
    }
}