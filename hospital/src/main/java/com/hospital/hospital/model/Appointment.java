package com.hospital.hospital.model;

import com.hospital.hospital.validator.AppointmentConstraint;
import com.hospital.hospital.validator.DoctorIdShouldExistConstraint;
import com.hospital.hospital.validator.PatientIdShouldExistConstraint;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "appointments")
@AppointmentConstraint
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "appointment_id")
    private
    Integer appointmentId;
    @NotNull
    @DoctorIdShouldExistConstraint
    @Column(name = "doctor_id")
    private
    Integer doctorId;
    @NotNull
    @PatientIdShouldExistConstraint
    @Column(name = "patient_id")
    private
    Integer patientId;
    @Column(name = "start_time")
    @Temporal(TemporalType.TIMESTAMP)
    private
    Date startTime;
    @Column(name = "end_time")
    @Temporal(TemporalType.TIMESTAMP)
    private
    Date endTime;
    @Column(name = "cause")
    private
    String cause;

    public Appointment() {
    }

    public Integer getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(Integer appointmentId) {
        this.appointmentId = appointmentId;
    }

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }
}
