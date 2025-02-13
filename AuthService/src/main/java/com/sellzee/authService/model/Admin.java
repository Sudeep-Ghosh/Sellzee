package com.sellzee.authService.model;

import org.springframework.data.mongodb.core.mapping.MongoId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Admin {
	@MongoId
	private String adminId;
	private String name;
	private String username;
	private String password;
	private String email;
	private String mobile;
	private String role = "ROLE_ADMIN";
}
