package com.hospital.hospital.service;


import com.hospital.hospital.model.Appointment;
import com.hospital.hospital.model.Doctor;
import com.hospital.hospital.model.Patient;
import com.hospital.hospital.utils.DateTimeUtils;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import java.io.StringWriter;
import java.text.ParseException;
import java.util.Date;
import java.util.Properties;

//https://www.baeldung.com/spring-email
//https://www.codepedia.org/ama/how-to-compose-html-emails-in-java-with-spring-and-velocity/
//https://www.technicalkeeda.com/spring-tutorials/spring-email-velocity-template-example
//https://stackoverflow.com/questions/9051413/unable-to-find-velocity-template-resources
// Obs: in setari: am modificat accesul astfel incat sa fie permis si aplicatiilor mai putin sigure
@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    MailSender mailSender;
    @Autowired
    VelocityEngine velocityEngine;


    public EmailServiceImpl() {
        Properties p = new Properties();
        p.setProperty("resource.loader", "class");
        p.setProperty("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
        Velocity.init(p);
    }

    @Override
    public void sendMessage() {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("bacaoanuioana@yahoo.com");
        message.setSubject("subject");
        message.setText("text");
        mailSender.send(message);
    }

    public void sendMessageToDoctor(Doctor doctor) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(doctor.getEmail().getEmail());
        message.setSubject("doctor account");

        Template template = Velocity.getTemplate("templates/doctorAccountMail.vm");

        VelocityContext velocityContext = new VelocityContext();
        velocityContext.put("firstName", doctor.getFirstName() != null ? doctor.getFirstName() : "-");
        velocityContext.put("lastName", doctor.getLastName() != null ? doctor.getLastName() : "-");
        velocityContext.put("function", doctor.getFunction() != null ? doctor.getFunction() : "-");
        velocityContext.put("address", doctor.getAddress() != null ? doctor.getAddress().toString() : "-");
        velocityContext.put("email", doctor.getEmail() != null ? doctor.getEmail().getEmail() : "-");
        velocityContext.put("phoneNumber", doctor.getPhoneNumber() != null ? doctor.getPhoneNumber().getPhoneNumber() : "-");

        sendMessage(message, template, velocityContext);
    }

    public void sendMessageToPatient(Patient patient) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(patient.getEmail().getEmail());
        message.setSubject("patient account");

        Template template = Velocity.getTemplate("templates/patientAccountMail.vm");

        VelocityContext velocityContext = new VelocityContext();
        velocityContext.put("firstName", patient.getFirstName() != null ? patient.getFirstName() : "-");
        velocityContext.put("lastName", patient.getLastName() != null ? patient.getLastName() : "-");
        velocityContext.put("age", patient.getAge() != null ? patient.getAge() : "-");
        velocityContext.put("address", patient.getAddress() != null ? patient.getAddress().toString() : "-");
        velocityContext.put("email", patient.getEmail() != null ? patient.getEmail().getEmail() : "-");
        velocityContext.put("phoneNumber", patient.getPhoneNumber() != null ? patient.getPhoneNumber().getPhoneNumber() : "-");

        sendMessage(message, template, velocityContext);
    }

    public void sendAppointmentMessageToPatient(Patient patient, Doctor doctor, Appointment appointment,
                                                String appointmentDate, String startTime, String endTime) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(patient.getEmail().getEmail());
        message.setSubject("Appointment Info");

        Template template = Velocity.getTemplate("templates/patientAppointmentMail.vm");

        VelocityContext velocityContext = getContextForAppointment(patient, doctor, appointment,
                appointmentDate, startTime, endTime);

        sendMessage(message, template, velocityContext);
    }

    public void sendAppointmentMessageToDoctor(Patient patient, Doctor doctor, Appointment appointment,
                                               String appointmentDate, String startTime, String endTime) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(doctor.getEmail().getEmail());
        message.setSubject("Appointment Info");

        Template template = Velocity.getTemplate("templates/doctorAppointmentMail.vm");

        VelocityContext velocityContext = getContextForAppointment(patient, doctor, appointment,
                appointmentDate, startTime, endTime);

        sendMessage(message, template, velocityContext);
    }

    public VelocityContext getContextForAppointment(Patient patient, Doctor doctor, Appointment appointment,
                                                    String appointmentDate, String startTime, String endTime) {
        VelocityContext velocityContext = new VelocityContext();
        velocityContext.put("patientName", patient.name());
        velocityContext.put("doctorName", doctor.name());
        velocityContext.put("date", appointmentDate);
        velocityContext.put("startTime", startTime);
        velocityContext.put("endTime", endTime);
        velocityContext.put("cause", appointment.getCause());
        return velocityContext;
    }

    private void sendMessage(SimpleMailMessage message, Template template, VelocityContext velocityContext) {
        StringWriter stringWriter = new StringWriter();

        template.merge(velocityContext, stringWriter);

        message.setText(stringWriter.toString());

        mailSender.send(message);
    }
}
