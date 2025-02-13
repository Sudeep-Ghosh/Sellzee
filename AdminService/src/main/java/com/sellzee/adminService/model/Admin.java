package com.sellzee.adminService.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "Admin")
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
