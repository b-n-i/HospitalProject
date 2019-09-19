package com.hospital.hospital.config;

import com.hospital.hospital.scheduler.ScheduledJob;
import com.hospital.hospital.utils.DateTimeUtils;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.Properties;

@Configuration
@EnableScheduling
public class AppConfig {

    @Bean
    public ScheduledJob scheduledJobBean(){
        return new ScheduledJob();
    }

    @Bean
    public JavaMailSender javaMailSenderBean(){
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);

        mailSender.setUsername("nicoleta.bni.21@gmail.com");
        mailSender.setPassword("myparolagmail369");

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");

        return mailSender;
    }

    @Bean
    public VelocityEngine velocityEngineBean(){
        return new VelocityEngine();
    }

}
