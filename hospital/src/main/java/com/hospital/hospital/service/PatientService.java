package com.hospital.hospital.service;

import com.hospital.hospital.model.Patient;
import com.hospital.hospital.repository.PatientRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class PatientService implements IPatientService {

    @Resource
    PatientRepository patientRepository;

    @Override
    public List<Patient> getAllPatients() {
        List<Patient> patients = new ArrayList<>();
        patientRepository.findAll().forEach(patients::add);
        return patients;
    }

    @Override
    public Patient getPatientById(Integer patientId) {
        return patientRepository.findById(patientId).orElse(null);
    }

    @Override
    public void addPatient(Patient patient) {
        patientRepository.save(patient);
    }

    @Override
    public void updatePatient(Patient patient) {
        patientRepository.save(patient);
    }

    @Override
    public void deletePatient(Integer patientId) {
        patientRepository.deleteById(patientId);
    }
}
