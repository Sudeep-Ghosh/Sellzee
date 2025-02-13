package com.sellzee.vehicleService.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.sellzee.vehicleService.model.User;


@FeignClient(url = "http://localhost:9101/user", value = "userClientForVehicle")
public interface UserClient {
	@GetMapping("/getUserById/{userId}")
	public User getUserById(@PathVariable String userId);
}
