package com.sellzee.emailService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sellzee.emailService.model.Email;
import com.sellzee.emailService.service.EmailService;

@RestController
@RequestMapping("/email")
public class EmailController {
	@Autowired
	private EmailService service;
	
	@PostMapping("/sendMail")
	public ResponseEntity<String> sendMail(@RequestBody Email mail){
		try {
			service.sendMail(mail);
			return new ResponseEntity<String>("Success",HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("Failed, Your Firewall Blocked the Connection",HttpStatus.OK);
		}
	}
}
