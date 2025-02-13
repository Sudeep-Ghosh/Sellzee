package com.sellzee.emailService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.sellzee.emailService.model.Email;
@Service
public class EmailServiceImpl implements EmailService {
	
	@Autowired
	private JavaMailSender javaMailSender;

	@Override
	public void sendMail(Email email) {
		// TODO Auto-generated method stub
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(email.getTo());
		message.setSubject(email.getSubject());
		message.setText(email.getText());
		
		javaMailSender.send(message);
		
	}

}
