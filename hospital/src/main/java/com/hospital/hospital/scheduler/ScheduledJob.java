package com.hospital.hospital.scheduler;

import com.hospital.hospital.repository.AppointmentRepository;
import com.hospital.hospital.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

public class ScheduledJob {

    @Autowired
    AppointmentService appointmentService;

    @Scheduled(fixedRate = 50000)
    public void markAppointmentsThatTookPlace(){
        appointmentService.markAppointmentsThatTookPlace();
    }
}
