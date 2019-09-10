package com.hospital.hospital.controller;

import com.hospital.hospital.dtos.PatientDTO;
import com.hospital.hospital.model.Patient;
import com.hospital.hospital.service.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
public class PatientController {

    @Autowired
    IPatientService patientService;


    @GetMapping("/patients")
    List<Patient> getAllPatients() {
        return patientService.getAllPatients();
    }

    @PostMapping("patient/save")
    void savePatient(@Valid @RequestBody Patient Patient, BindingResult result) {
        patientService.addPatient(Patient);
    }

    @GetMapping("/patients/{id}")
    Patient getPatientById(@PathVariable Integer id) {
        return patientService.getPatientById(id);
    }

    @PatchMapping("patient/update")
    void updatePatient(@Valid @RequestBody PatientDTO patientDTO, BindingResult result) {
        Patient oldPatient = patientService.getPatientById(patientDTO.getId());
        try {
            patientService.updatePatient(patientDTO);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @DeleteMapping(value = "/patient/delete/{id}")
    public void deletePatient(@PathVariable Integer id) {
        patientService.deletePatient(id);
    }

}
