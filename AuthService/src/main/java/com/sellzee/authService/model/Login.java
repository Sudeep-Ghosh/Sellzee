package com.sellzee.authService.model;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Users")
public class Login {
	private String username;
	private String password;
	private String role;
	private String userId;
}
