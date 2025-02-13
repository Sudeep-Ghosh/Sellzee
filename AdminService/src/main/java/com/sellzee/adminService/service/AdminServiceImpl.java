package com.sellzee.adminService.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sellzee.adminService.clients.UserClient;
import com.sellzee.adminService.exception.AdminException;
import com.sellzee.adminService.model.Admin;
import com.sellzee.adminService.model.User;
import com.sellzee.adminService.repository.AdminRepository;

@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	private AdminRepository adminRepository;
	
	@Autowired
	private UserClient userclient;

	@Override
	public Admin addAdmin(Admin admin) {
		// TODO Auto-generated method stub
		return adminRepository.save(admin);
	}

	@Override
	public Admin updateAdmin(Admin admin, String adminId) throws AdminException {
		// TODO Auto-generated method stub
		Optional<Admin> optAdmin = adminRepository.findById(adminId);
		if(optAdmin.isPresent()) {
			Admin existingAdmin = optAdmin.get();
			return adminRepository.save(existingAdmin);
		}
		else {
			throw new AdminException("No Admin Found!!");
		}
	}

	@Override
	public Admin getAdminByUsername(String username) throws AdminException {
		// TODO Auto-generated method stub
		Optional<Admin> optAdmin = Optional.ofNullable(adminRepository.findByUsername(username));
		if(optAdmin.isPresent()) {
			return optAdmin.get();
		}
		else {
			throw new AdminException("Admin Not Found with the given UserName!!");
		}
	}

	@Override
	public Admin deleteAdmin(String userId) throws AdminException {
		// TODO Auto-generated method stub
		Optional<Admin> optAdmin = adminRepository.findById(userId);
		if(optAdmin.isPresent()) {
			adminRepository.deleteById(userId);
			return optAdmin.get();
		}
		else {
			throw new AdminException("Admin not found!!");
		}
	}

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return userclient.getAllUsers();
	}

	@Override
	public User getUserById(String userId) {
		// TODO Auto-generated method stub
		return userclient.getUserById(userId);
	}

	@Override
	public User getUserByUsername(String username) {
		// TODO Auto-generated method stub
		return userclient.getUserByUsername(username);
	}

	@Override
	public User deleteUser(String userId) {
		// TODO Auto-generated method stub
		return userclient.deleteUser(userId);
	}

}
