package com.sellzee.authService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sellzee.authService.clients.AdminClient;
import com.sellzee.authService.clients.UserClient;
import com.sellzee.authService.model.Admin;
import com.sellzee.authService.model.Login;
import com.sellzee.authService.model.User;

import feign.FeignException;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private UserClient userClient;
	
	@Autowired
	private AdminClient adminClient;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Login user = this.load(username);
		if(user == null) {
			throw new UsernameNotFoundException("User Not Found with the username: "+username);
		}
		return UserDetailsImpl.getUser(user);
	}
	
	public Login load(String username) throws UsernameNotFoundException{
		try {
			User user = userClient.getUserByUsername(username);
			Login userModel = new Login(user.getUsername(), user.getPassword(), user.getRole(), user.getUserId());
			return userModel;
		}catch(FeignException.NotFound notFoundException) {
			Admin admin = adminClient.getAdminByUsername(username);
			if(admin !=null) {
				Login userModel = new Login(admin.getUsername(), admin.getPassword(), admin.getRole(), admin.getAdminId());
				return userModel;
			}
		}
		return null;
	}

}
