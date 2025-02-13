package com.sellzee.adminService.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import com.sellzee.adminService.model.User;

@FeignClient(url = "http://localhost:9101/user", name = "userClientForAdmin")
public interface UserClient {
	
	
	@GetMapping("/getUserById/{userId}")
	public User getUserById(@PathVariable String userId);
	
	@GetMapping("/getUserByUsername/{username}")
	public User getUserByUsername(@PathVariable String username);
	
	@GetMapping("/getAllUsers")
	public List<User> getAllUsers();
	
	@DeleteMapping("/deleteUser/{userId}")
	public User deleteUser(@PathVariable String userId);
}
