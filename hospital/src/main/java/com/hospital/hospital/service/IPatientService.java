package com.hospital.hospital.service;

import com.hospital.hospital.model.Patient;

import java.util.List;

public interface IPatientService {
    List<Patient> getAllPatients();
    Patient getPatientById(Integer patientId);
    void addPatient(Patient patient);
    void updatePatient(Patient patient);
    void deletePatient(Integer patientId);
}
