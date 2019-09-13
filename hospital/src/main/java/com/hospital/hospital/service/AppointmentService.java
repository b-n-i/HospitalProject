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
import java.util.concurrent.TimeUnit;

@Service
public class AppointmentService implements IAppointmentService {

    static final Integer TIME_LIMIT_BEFORE_CANCEL = 60;

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
    public void updateAppointment(Appointment appointment) {
        appointmentRepository.save(appointment);
    }

    @Override
    public void deleteAppointment(Integer appointmentId) {
        appointmentRepository.deleteById(appointmentId);
    }


//    public List<Appointment> getAppointmentsFromInterval(Date startDate, Date endDate) {
////        da eroare deoarece utilizez aici repository
//        List<Appointment> appointments = getAllAppointments();
//        List<Appointment> appointmentsFromInterval = new ArrayList<>();
//        for(Appointment appointment: appointments)
//        {
//            if ((appointment.getEndTime().after(startDate) && appointment.getEndTime().before(endDate))
//                    || (appointment.getStartTime().after(startDate) && appointment.getStartTime().before(endDate))) {
//                appointmentsFromInterval.add(appointment);
//            }
//        }
//        return appointmentsFromInterval;
//    }

    public List<Appointment> getAppointmentsByDoctorId( Integer doctorId){
        return appointmentRepository.getAppointmentByDoctorId(doctorId);
    }

    public List<Appointment> getAppointmentsByPatientId( Integer doctorId){
        return appointmentRepository.getAppointmentByPatientId(doctorId);
    }

    public List<Appointment> getAppointmentsDoctorIdBeforeDate(Integer doctorId, Date date){
        return appointmentRepository.findByDoctorIdAndStartTimeBefore(doctorId, date);
    }

    public List<Appointment> getAppointmentAfterDate(Date date){
        return appointmentRepository.findByStartTimeAfter(date);
    }

    public Boolean canBeCancelled( Appointment appointmentToBeCancelled){
        Date appointmentStartTime = appointmentToBeCancelled.getStartTime();
        Date currentDate = new Date(System.currentTimeMillis());
        if(!appointmentToBeCancelled.getTookPlace() && appointmentStartTime.after(currentDate)){
            long milliSeconds = appointmentStartTime.getTime() - currentDate.getTime();
            long diffMinutes = TimeUnit.MINUTES.convert(milliSeconds, TimeUnit.MILLISECONDS);
            System.out.println(appointmentStartTime);
            System.out.println(currentDate);
            System.out.println(diffMinutes);
            return diffMinutes > TIME_LIMIT_BEFORE_CANCEL;
        }
        return false;
    }
}
