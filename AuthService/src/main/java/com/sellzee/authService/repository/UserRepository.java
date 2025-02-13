package com.sellzee.authService.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.sellzee.authService.model.Login;

public interface UserRepository extends MongoRepository<Login, String> {
	Login findByUsername(String username);
}
