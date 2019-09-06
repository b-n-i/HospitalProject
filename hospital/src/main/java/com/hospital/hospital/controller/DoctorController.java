package com.hospital.hospital.controller;

import com.hospital.hospital.model.Doctor;
import com.hospital.hospital.service.IDoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DoctorController {

    @Autowired
    IDoctorService doctorService;


    @GetMapping("/doctors")
    List<Doctor> getAllDoctors() {
        return doctorService.getAllDoctors();
    }

    @PostMapping("doctor/save")
    void saveDoctor(@Valid @RequestBody Doctor doctor, BindingResult result) {
        doctorService.addDoctor(doctor);
    }

    @GetMapping("/doctors/{id}")
    Doctor getDoctorById(@PathVariable Integer id) {
        return doctorService.getDoctorById(id);
    }

    @PostMapping("doctor/update")
    void updateDoctor(@Valid @RequestBody Doctor doctor, BindingResult result) {
        doctorService.updateDoctor(doctor);
    }

    @DeleteMapping(value = "/doctor/delete/{id}")
    public void deleteDelete(@PathVariable Integer id) {
        doctorService.deleteDoctor(id);
    }
}
