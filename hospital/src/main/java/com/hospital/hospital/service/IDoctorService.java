package com.hospital.hospital.service;

import com.hospital.hospital.model.Doctor;

import java.util.List;

public interface IDoctorService {
    List<Doctor> getAllDoctors();
    Doctor getDoctorById(Integer doctorId);
    void addDoctor(Doctor doctor);
    void updateDoctor(Doctor doctor);
    void deleteDoctor(Integer doctorId);
}
