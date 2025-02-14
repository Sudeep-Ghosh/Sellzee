package com.sellzee.authService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sellzee.authService.clients.VehicleClient;
import com.sellzee.authService.dto.VehicleDTO;
import com.sellzee.authService.model.Vehicle;
import com.sellzee.authService.model.VehicleDetails;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {
	
	@Autowired
	private VehicleClient vehicleClient;
	
	@PostMapping("/addVehicle")
	@PreAuthorize("hasRole('SELLER')")
	public ResponseEntity<Vehicle> addVehicle(@RequestBody @Valid Vehicle vehicle){
		return new ResponseEntity<> (vehicleClient.addVehicle(vehicle), HttpStatus.OK);
	}
	
	@PutMapping("/updateVehicle/{vehicleId}")
	@PreAuthorize("hasRole('SELLER')")
	public ResponseEntity<Vehicle> updateVehicle(@RequestBody VehicleDTO vehicle, @PathVariable String vehicleId){
		return new ResponseEntity<> (vehicleClient.updateVehicle(vehicle, vehicleId), HttpStatus.OK);
	}
	
	@GetMapping("/getVehicleById/{vehicleId}")
	@PreAuthorize("hasAnyRole('SELLER','ADMIN','BUYER')")
	public ResponseEntity<Vehicle> getVehicleById(@PathVariable String vehicleId){
		Vehicle vehicle = vehicleClient.getVehicleById(vehicleId);
		return ResponseEntity.ok(vehicle);
	}
	
	@GetMapping("/getAllVehicles")
	@PreAuthorize("hasRole('ADMIN','BUYER')")
	public ResponseEntity<List<Vehicle>> getAllVehicles() {
		List<Vehicle> vehicles = vehicleClient.getAllVehicles();
		return ResponseEntity.ok(vehicles);
	}
	
	@DeleteMapping("/deleteVehicle/{vehicleId}")
	@PreAuthorize("hasAnyRole('SELLER','ADMIN')")
	public ResponseEntity<Vehicle> deleteVehicle(@PathVariable String vehicleId){
		Vehicle vehicle = vehicleClient.deleteVehicle(vehicleId);
		return ResponseEntity.ok(vehicle);
	}
	
	@PostMapping("/addVehicleDetails/{vehicleId}")
	@PreAuthorize("hasRole('SELLER')")
	public ResponseEntity<VehicleDetails> addVehicleDetails(@PathVariable String vehicleId, @RequestBody VehicleDetails vehicleDetails){
		return new ResponseEntity<>(vehicleClient.addVehicleDetails(vehicleId, vehicleDetails),HttpStatus.OK);
	}
}
