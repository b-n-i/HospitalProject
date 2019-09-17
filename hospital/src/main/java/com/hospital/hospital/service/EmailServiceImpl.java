package com.hospital.hospital.service;


import com.hospital.hospital.model.Doctor;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;
import org.springframework.ui.velocity.VelocityEngineUtils;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

//https://www.baeldung.com/spring-email
//https://www.codepedia.org/ama/how-to-compose-html-emails-in-java-with-spring-and-velocity/
// Obs: in setari: am modificat accesul astfel incat sa fie permis si aplicatiilor mai putin sigure
@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    JavaMailSender javaMailSender;
    @Autowired
    VelocityEngine velocityEngine;

    @Override
    public void sendMessage(){

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("bacaoanuioana@yahoo.com");
        message.setSubject("subject");
        message.setText("text");
        javaMailSender.send(message);
    }
}
