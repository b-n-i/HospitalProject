package com.hospital.hospital.repository;

import com.hospital.hospital.model.Doctor;
import org.springframework.data.repository.CrudRepository;

public interface DoctorRepository extends CrudRepository<Doctor, Integer> {

}
