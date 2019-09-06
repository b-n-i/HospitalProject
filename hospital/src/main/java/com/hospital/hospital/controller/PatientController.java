package com.hospital.hospital.controller;

import com.hospital.hospital.model.Patient;
import com.hospital.hospital.service.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @PostMapping("patient/update")
    void updatePatient(@Valid @RequestBody Patient Patient, BindingResult result) {
        patientService.updatePatient(Patient);
    }

    @DeleteMapping(value = "/patient/delete/{id}")
    public void deleteDelete(@PathVariable Integer id) {
        patientService.deletePatient(id);
    }

}
