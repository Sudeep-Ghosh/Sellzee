package com.sellzee.dto;

import org.springframework.data.mongodb.core.mapping.MongoId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
	@MongoId
	private String userId;
	private String name;
	private String username;
	private String email;
	private String mobile;
}
