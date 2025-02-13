package com.sellzee.authService.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.sellzee.authService.dto.UserDTO;
import com.sellzee.authService.model.User;


@FeignClient(url = "http://localhost:9101/user", value = "userClientForAuth")
public interface UserClient {

	@PostMapping("/registerUser")
	public User registerUser(@RequestBody User user);
	
	@PutMapping("/updateUser/{userId}")
	public User updateUser(@RequestBody UserDTO user, @PathVariable String userId);
	
	@GetMapping("/getUserById/{userId}")
	public User getUserById(@PathVariable String userId);
	
	@GetMapping("/getUserByUsername/{username}")
	public User getUserByUsername(@PathVariable String username);
	
	@GetMapping("/getAllUsers")
	public List<User> getAllUsers();
	
	@DeleteMapping("/deleteUser/{userId}")
	public User deleteUser(@PathVariable String userId);
}
