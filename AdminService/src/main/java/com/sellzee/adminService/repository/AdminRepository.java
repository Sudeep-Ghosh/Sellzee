package com.sellzee.adminService.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.sellzee.adminService.model.Admin;

@Repository
public interface AdminRepository extends MongoRepository<Admin, String> {
	Admin findByUsername(String username);
}
