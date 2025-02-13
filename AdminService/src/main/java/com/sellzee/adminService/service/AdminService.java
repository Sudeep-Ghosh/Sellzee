package com.sellzee.adminService.service;

import java.util.List;

import com.sellzee.adminService.exception.AdminException;
import com.sellzee.adminService.model.Admin;
import com.sellzee.adminService.model.User;


public interface AdminService {
	Admin addAdmin(Admin admin);
	Admin updateAdmin(Admin admin, String adminId) throws AdminException;
	Admin getAdminByUsername(String username) throws AdminException;
	Admin deleteAdmin(String userId) throws AdminException;
	//User updateUser(UserDTO user, String userId);
	List<User> getAllUser();
	User getUserById(String userId);
	User getUserByUsername(String username);
	User deleteUser(String userId);
}
