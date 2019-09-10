package com.hospital.hospital.controller;

import com.hospital.hospital.model.Doctor;
import com.hospital.hospital.service.IDoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;
import java.util.Map;

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

    @PatchMapping("doctor/update")
    void updateDoctor(@RequestBody String rawJson, BindingResult result) {
        try {
            doctorService.updateDoctor(rawJson);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @DeleteMapping(value = "/doctor/delete/{id}")
    public void deleteDoctor(@PathVariable Integer id) {
        doctorService.deleteDoctor(id);
    }

}
