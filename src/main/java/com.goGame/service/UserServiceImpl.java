package com.goGame.service;

import org.springframework.stereotype.Service;

import com.goGame.commands.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

/**
 * Created by ravi on 4/7/17.
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    JavaMailSender javaMailSender;
    @Override
    public void sendSimpleEmail(Email email) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("ravikumaraggarwalabc+4@gmail.com");
        message.setSubject(email.getSub());
        message.setText(email.getContent());
        javaMailSender.send(message);
    }
}
