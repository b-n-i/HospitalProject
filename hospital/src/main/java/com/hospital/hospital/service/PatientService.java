package com.hospital.hospital.service;

import com.hospital.hospital.dtos.PatientDTO;
import com.hospital.hospital.model.Patient;
import com.hospital.hospital.repository.PatientRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

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
    public void updatePatient(PatientDTO patientDTO) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Patient patient = patientRepository.findById(patientDTO.getId()).get();
        List<String> fieldsToBeUpdated = patientDTO.getFieldsToBeUpdated();
        Method setter;
        Method getter;
        for (String field : fieldsToBeUpdated) {
            getter = patientDTO.getClass().getMethod("get" + field);
            setter = patient.getClass().getMethod("set" + field, getter.invoke(patientDTO).getClass());
            setter.invoke(patient, getter.invoke(patientDTO));
        }
        patientRepository.save(patient);
    }

    @Override
    public void deletePatient(Integer patientId) {
        patientRepository.deleteById(patientId);
    }
}
