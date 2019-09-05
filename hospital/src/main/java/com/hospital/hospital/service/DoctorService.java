package com.hospital.hospital.service;

import com.hospital.hospital.model.Doctor;
import com.hospital.hospital.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
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
    public Doctor getDoctorById(Integer doctorId) {
        return null;
    }

    @Override
    public boolean addDoctor(Doctor doctor) {
        return false;
    }

    @Override
    public void updateDoctor(Doctor doctor) {

    }

    @Override
    public void deleteDoctor(Integer doctorId) {

    }
}
