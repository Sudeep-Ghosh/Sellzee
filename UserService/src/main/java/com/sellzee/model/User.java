package com.sellzee.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "Users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	@MongoId
	private String userId;
	private String name;
	private String username;
	private String email;
	private String password;
	private String mobile;
	private String role;
}
