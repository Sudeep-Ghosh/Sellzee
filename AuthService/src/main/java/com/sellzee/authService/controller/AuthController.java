package com.sellzee.authService.controller;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sellzee.authService.clients.AdminClient;
import com.sellzee.authService.clients.UserClient;
import com.sellzee.authService.jwt.JwtUtility;
import com.sellzee.authService.model.Admin;
import com.sellzee.authService.model.User;
import com.sellzee.authService.request.LoginRequest;
import com.sellzee.authService.response.JSONResponse;
import com.sellzee.authService.service.UserDetailsImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/public")
public class AuthController {
	@Autowired
	private DaoAuthenticationProvider provider;
	@Autowired
	private JwtUtility jwtUtility;
	@Autowired
	private UserClient userClient;
	@Autowired
	private AdminClient adminClient;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@PostMapping("/login")
	public ResponseEntity<?> validateUser(@Valid @RequestBody LoginRequest loginRequest){
		Authentication auth = provider.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(auth);
		UserDetailsImpl user = (UserDetailsImpl) auth.getPrincipal();
		String token = jwtUtility.generateToken(auth);
		
		Collection<? extends GrantedAuthority> authorities = user.getAuthorities();
		List<String> list = authorities.stream().map(GrantedAuthority :: getAuthority).collect(Collectors.toList());
		JSONResponse res = new JSONResponse(token, user.getUsername(), list,user.getUserId());
		return ResponseEntity.ok(res);
	}
	
	@PostMapping("/registerUser")
	public ResponseEntity<User> registerUser(@Valid @RequestBody User user){
		String password = passwordEncoder.encode(user.getPassword());
		user.setPassword(password);
		User registeredUser = userClient.registerUser(user);
		return ResponseEntity.ok(registeredUser);
		
	}
	
	@PostMapping("/registerAdmin")
	public ResponseEntity<Admin> registerAdmin(@Valid @RequestBody Admin admin){
		String password = passwordEncoder.encode(admin.getPassword());
		admin.setPassword(password);
		Admin registeredAdmin = adminClient.addAdmin(admin);
		return ResponseEntity.ok(registeredAdmin);
	}
}