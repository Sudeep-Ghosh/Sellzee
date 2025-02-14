package com.sellzee.authService.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.sellzee.authService.model.Admin;
import com.sellzee.authService.model.User;

import jakarta.validation.Valid;

@FeignClient(url = "http://localhost:9103/admin",value = "adminClientForAuths")
public interface AdminClient {
	@PostMapping("/addAdmin")
	public Admin addAdmin(@Valid @RequestBody Admin admin);
	
	@PutMapping("/updateAdmin/{adminId}}")
	public Admin updateAdmin(@RequestBody Admin admin,@PathVariable String adminId);
	
	@GetMapping("/getAdminByUsername/{username}")
	public Admin getAdminByUsername(@PathVariable String username);
	
	@DeleteMapping("/deleteAdmin/{adminId}")
	public Admin deleteAdmin(@PathVariable String adminId);
	
	@GetMapping("/getAllUsers")
	public List<User> getAllUsers();
	
	@GetMapping("/getUserById/{userId}")
	public User getUserById(@PathVariable String userId);
	
	@GetMapping("/getUserByUserName/{username")
	public User getUserByUsername(@PathVariable String userName);
	
	@DeleteMapping("/deleteUser/{userId}")
	public User deleteUser(@PathVariable String userId);
}
