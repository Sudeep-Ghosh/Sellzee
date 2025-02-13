package com.sellzee.authService.response;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class JSONResponse {
	private String token;
	private String type ="Bearer";
	private String userId;
	private String username;
	private List<String> roles;
	
	public JSONResponse(String accessToken,String username, List<String> roles) {
		this.token = accessToken;
		this.username = username;
		this.roles = roles;
	}
	
	public JSONResponse(String accessToken,String username,List<String> roles,String userId) {
		this.token = accessToken;
		this.username = username;
		this.userId = userId;
		this.roles = roles;
	}
}
