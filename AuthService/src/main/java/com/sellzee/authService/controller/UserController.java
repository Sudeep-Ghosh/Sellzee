package com.sellzee.authService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sellzee.authService.clients.UserClient;
import com.sellzee.authService.dto.UserDTO;
import com.sellzee.authService.model.User;


@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserClient userClient;
	
	
	@PutMapping("/updateUser/{userId}")
	@PreAuthorize("hasAnyRole('SELLER','BUYER')")
	public ResponseEntity<User> updateUser(@RequestBody UserDTO user, @PathVariable String userId){
		
		return new ResponseEntity<User>(userClient.updateUser(user, userId),HttpStatus.OK);
	}
	
	@GetMapping("/getUserById/{userId}")
	@PreAuthorize("hasAnyRole('ADMIN')")
	public ResponseEntity<User> getUserById(@PathVariable String userId){
		User user = userClient.getUserById(userId);
		return ResponseEntity.ok(user);
	}
	
	@GetMapping("/getUserByUsername/{username}")
	@PreAuthorize("hasAnyRole('ADMIN')")
	public ResponseEntity<User> getUserByUsername(@PathVariable String username) {
		User user = userClient.getUserByUsername(username);
		return ResponseEntity.ok(user);
	}
	
	@GetMapping("/getAllUsers")
	@PreAuthorize("hasAnyRole('ADMIN')")
	public ResponseEntity<List<User>> getAllUsers() {
		List<User> users = userClient.getAllUsers();
		return ResponseEntity.ok(users);
	}
	
	@DeleteMapping("/deleteUser/{userId}")
	@PreAuthorize("hasAnyRole('ADMIN','SELLER','BUYER')")
	public ResponseEntity<User> deleteUser(@PathVariable String userId) {
		User user = userClient.deleteUser(userId);
		return ResponseEntity.ok(user);
	}
}
