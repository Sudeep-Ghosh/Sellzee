package com.sellzee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sellzee.dto.UserDTO;
import com.sellzee.exception.UserInvalidException;
import com.sellzee.model.User;
import com.sellzee.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService service;
	
	@PostMapping("/registerUser")
	public ResponseEntity<User> registerUser(@RequestBody User user) throws UserInvalidException{
		return new ResponseEntity<>(service.registerUser(user), HttpStatus.OK);
	}
	
	@PutMapping("/updateUser/{userId}")
	public ResponseEntity<User> updateUser(@RequestBody UserDTO user, @PathVariable String userId) throws UserInvalidException{
		return new ResponseEntity<User>(service.updateUser(user, userId),HttpStatus.OK);
	}
	
	@GetMapping("/getUserById/{userId}")
	public ResponseEntity<User> getUserById(@PathVariable String userId) throws UserInvalidException{
		return new ResponseEntity<> (service.getUserById(userId),HttpStatus.OK);
	}
	
	@GetMapping("/getUserByUsername/{username}")
	public ResponseEntity<User> getUserByUsername(@PathVariable String username) throws UserInvalidException{
		return new ResponseEntity<User>(service.getUserByUsername(username),HttpStatus.OK);
	}
	
	@GetMapping("/getAllUsers")
	public ResponseEntity<List<User>> getAllUsers() throws UserInvalidException{
		return new ResponseEntity<List<User>>(service.getAllUser(),HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteUser/{userId}")
	public ResponseEntity<User> deleteUser(@PathVariable String userId) throws UserInvalidException{
		return new ResponseEntity<>(service.deleteUser(userId),HttpStatus.OK);
	}
}
