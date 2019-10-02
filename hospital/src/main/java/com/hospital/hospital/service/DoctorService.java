package com.hospital.hospital.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hospital.hospital.model.Address;
import com.hospital.hospital.model.Doctor;
import com.hospital.hospital.model.Email;
import com.hospital.hospital.model.PhoneNumber;
import com.hospital.hospital.repository.DoctorRepository;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
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
        return doctorRepository.findById(doctorId).orElse(null);
    }

    @Override
    public void addDoctor(Doctor doctor) {
        doctorRepository.save(doctor);
    }

    @Override
    public void updateDoctor(String rawJson) throws IOException {
//        https://www.baeldung.com/http-put-patch-difference-spring
//       Inspiration:     https://code-examples.net/en/q/e6c97a

        ObjectMapper mapper = new ObjectMapper();
        JSONObject json = new JSONObject(rawJson);
        Integer doctorId = (Integer) json.get("id");
        Doctor updatedDoctor = doctorRepository.findById(doctorId).get();
        for (String key : json.keySet()) {
            switch (key) {
                case "firstName":
                    updatedDoctor.setFirstName((String) json.get(key));
                    break;
                case "lastName":
                    updatedDoctor.setLastName((String) json.get(key));
                    break;
                case "function":
                    updatedDoctor.setFunction((String) json.get(key));
                    break;
                case "address":
                    updatedDoctor.setAddress(mapper.readValue(json.get(key).toString(), Address.class));
                    break;
                case "email":
                    updatedDoctor.setEmail(mapper.readValue(json.get(key).toString(), Email.class));
                    break;
                case "phoneNumber":
                    updatedDoctor.setPhoneNumber(mapper.readValue(json.get(key).toString(), PhoneNumber.class));
                    break;
            }
        }
        doctorRepository.save(updatedDoctor);
    }

    @Override
    public void deleteDoctor(Integer doctorId) {
        doctorRepository.deleteById(doctorId);
    }
}
