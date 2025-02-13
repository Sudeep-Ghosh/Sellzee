package com.sellzee.authService.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.sellzee.authService.dto.VehicleDTO;
import com.sellzee.authService.model.Vehicle;
import com.sellzee.authService.model.VehicleDetails;

import jakarta.validation.Valid;

@FeignClient(url = "http://localhost:9102/vehicle", value = "vehicleClientForAuth")
public interface VehicleClient {
	@PostMapping("/addVehicle")
	public Vehicle addVehicle(@RequestBody @Valid Vehicle vehicle);
	
	@PutMapping("/updateVehicle/{vehicleId}")
	public Vehicle updateVehicle(@RequestBody VehicleDTO vehicle, @PathVariable String vehicleId);
	
	@GetMapping("/getVehicleById/{vehicleId}")
	public Vehicle getVehicleById(@PathVariable String vehicleId);
	
	@GetMapping("/getAllVehicles")
	public List<Vehicle> getAllVehicles();
	
	@DeleteMapping("/deleteVehicle/{vehicleId}")
	public Vehicle deleteVehicle(@PathVariable String vehicleId);
	
	@PostMapping("/addVehicleDetails/{vehicleId}")
	public VehicleDetails addVehicleDetails(@PathVariable String vehicleId, @RequestBody VehicleDetails vehicleDetails);
}
