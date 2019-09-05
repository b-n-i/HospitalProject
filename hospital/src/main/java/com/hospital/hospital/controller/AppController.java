package com.hospital.hospital.controller;

import com.hospital.hospital.model.Doctor;
import com.hospital.hospital.service.IDoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class AppController {

    @Autowired
    IDoctorService doctorService;

    @GetMapping("/")
    List<Doctor> getAllDoctors(){
        return doctorService.getAllDoctors();
    }

    @PostMapping("/")
    ResponseEntity<String> validateBody(@Valid @RequestBody Doctor doctor) {
        doctorService.addDoctor(doctor);
        return ResponseEntity.ok("valid");
    }

}
