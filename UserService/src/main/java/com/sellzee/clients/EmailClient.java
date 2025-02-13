package com.sellzee.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.sellzee.model.Email;


@FeignClient(url = "http://localhost:8787/email",name = "emailClient")
public interface EmailClient {
	@PostMapping("/sendMail")
	public String sendMail(@RequestBody Email mail);
}
