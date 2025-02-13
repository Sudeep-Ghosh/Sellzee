package com.sellzee.adminService.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	private String userId;
	private String name;
	private String userName;
	private String email;
	private String password;
	private String mobile;
	private String role;
}
