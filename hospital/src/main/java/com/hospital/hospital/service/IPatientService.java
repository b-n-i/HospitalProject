package com.hospital.hospital.service;

import com.hospital.hospital.dtos.PatientDTO;
import com.hospital.hospital.model.Patient;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public interface IPatientService {
    List<Patient> getAllPatients();

    Patient getPatientById(Integer patientId);

    void addPatient(Patient patient);

    void updatePatient(PatientDTO patient) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException;

    void deletePatient(Integer patientId);
}
