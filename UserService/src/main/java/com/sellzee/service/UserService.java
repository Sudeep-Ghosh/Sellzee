package com.sellzee.service;

import java.util.List;
import java.util.Optional;

import com.sellzee.dto.UserDTO;
import com.sellzee.exception.UserInvalidException;
import com.sellzee.model.User;

public interface UserService {
	User registerUser(User user) throws UserInvalidException;
	User updateUser(UserDTO user, String userId) throws UserInvalidException;
	List<User> getAllUser() throws UserInvalidException;
	User getUserById(String userId) throws UserInvalidException;
	User getUserByUsername(String username) throws UserInvalidException;
	User deleteUser(String userId) throws UserInvalidException;
}
