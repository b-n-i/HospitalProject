package com.hospital.hospital.service;

import com.hospital.hospital.model.Appointment;
import com.hospital.hospital.repository.AppointmentRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class AppointmentService implements IAppointmentService {

    @Resource
    AppointmentRepository appointmentRepository;

    @Override
    public List<Appointment> getAllAppointments() {
        List<Appointment> appointments = new ArrayList<>();
        appointmentRepository.findAll().forEach(appointments::add);
        return appointments;
    }

    @Override
    public Appointment getAppointmentById(Integer appointmentId) {
        return appointmentRepository.findById(appointmentId).orElse(null);
    }

    @Override
    public void addAppointment(Appointment appointment) {
        appointmentRepository.save(appointment);
    }

    @Override
    public void deleteAppointment(Integer appointmentId) {
        appointmentRepository.deleteById(appointmentId);
    }


    public List<Appointment> getAppointmentsFromInterval(Date startDate, Date endDate) {
        List<Appointment> appointments = new ArrayList<>();
        appointmentRepository.findAll().forEach(appointments::add);
        for(Appointment appointment: appointments)
        {
            if ((appointment.getEndTime().after(startDate) && appointment.getEndTime().before(endDate))
                    || (appointment.getStartTime().after(startDate) && appointment.getStartTime().before(endDate))) {
                appointments.add(appointment);
                System.out.println(appointment);
            }
        }
        return appointments;
    }

    public List<Appointment> getAppointmentsByDoctorId( Integer doctorId){
        return appointmentRepository.getAppointmentByDoctorId(doctorId);
    }
}
