package com.hospital.hospital.service;

import com.hospital.hospital.model.Doctor;
import com.hospital.hospital.repository.DoctorRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class DoctorService implements IDoctorService {


    @Resource
    DoctorRepository doctorRepository;

    @Override
    public List<Doctor> getAllDoctors() {
        List<Doctor> doctors = new ArrayList<>();
        doctorRepository.findAll().forEach(doctors::add);
        return doctors;
    }

    @Override
    public Doctor getDoctorById(Integer doctorId)
    {
        return doctorRepository.findById(doctorId).orElse(null);
    }

    @Override
    public void addDoctor(Doctor doctor) {
        doctorRepository.save(doctor);
    }

    @Override
    public void updateDoctor(Doctor doctor) {
        doctorRepository.save(doctor);
    }

    @Override
    public void deleteDoctor(Integer doctorId) {
        doctorRepository.deleteById(doctorId);
    }
}
