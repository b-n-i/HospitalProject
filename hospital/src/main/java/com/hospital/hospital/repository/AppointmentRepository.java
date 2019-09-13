package com.hospital.hospital.repository;

import com.hospital.hospital.model.Appointment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface AppointmentRepository extends CrudRepository<Appointment, Integer> {


//    Query derived from method name (https://docs.spring.io/spring-data/jpa/docs/1.5.0.RELEASE/
//    reference/html/jpa.repositories.html#jpa.query-methods.named-queries

    public List<Appointment> getAppointmentByDoctorId(Integer doctorId);
    public List<Appointment> getAppointmentByPatientId(Integer patientId);
    public List<Appointment> findByStartTimeAfter(Date date);
    public List<Appointment> findByDoctorIdAndStartTimeBefore(Integer doctorId, Date date);
    @Query(value = "SELECT * FROM appointments a WHERE (a.end_time>= ?1 and a.end_time<= ?2)" +
            " or (a.start_time>= ?1 and a.start_time<= ?2)", nativeQuery = true)
    public List<Appointment> getAppointmentsFromInterval(Date startDate,Date endDate);

}

