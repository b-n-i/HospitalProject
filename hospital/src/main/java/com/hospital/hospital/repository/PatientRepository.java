package com.hospital.hospital.repository;

import com.hospital.hospital.model.Patient;
import org.springframework.data.repository.CrudRepository;

public interface PatientRepository extends CrudRepository<Patient, Integer> {
}
