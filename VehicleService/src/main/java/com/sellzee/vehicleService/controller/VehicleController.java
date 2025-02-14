package com.sellzee.vehicleService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sellzee.vehicleService.dto.VehicleDTO;
import com.sellzee.vehicleService.exception.VehicleInvalidException;
import com.sellzee.vehicleService.model.Vehicle;
import com.sellzee.vehicleService.model.VehicleDetails;
import com.sellzee.vehicleService.service.VehicleService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {
	@Autowired
	private VehicleService service;
	
	@PostMapping("/addVehicle")
	public ResponseEntity<Vehicle> addVehicle(@RequestBody @Valid Vehicle vehicle){
		return new ResponseEntity<> (service.addVehicle(vehicle), HttpStatus.OK);
	}
	
	@PutMapping("/updateVehicle/{vehicleId}")
	public ResponseEntity<Vehicle> updateVehicle(@RequestBody VehicleDTO vehicle, @PathVariable String vehicleId) throws VehicleInvalidException{
		return new ResponseEntity<> (service.updateVehicle(vehicle, vehicleId), HttpStatus.OK);
	}
	
	@GetMapping("/getVehicleById/{vehicleId}")
	public ResponseEntity<Vehicle> getVehicleById(@PathVariable String vehicleId) throws VehicleInvalidException{
		return new ResponseEntity<Vehicle> (service.getVehicleById(vehicleId),HttpStatus.OK);
	}
	
	@GetMapping("/getAllVehicles")
	public ResponseEntity<List<Vehicle>> getAllVehicles() throws VehicleInvalidException{
		return new ResponseEntity<List<Vehicle>> (service.getAllVehicles(),HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteVehicle/{vehicleId}")
	public ResponseEntity<Vehicle> deleteVehicle(@PathVariable String vehicleId) throws VehicleInvalidException{
		return new ResponseEntity<Vehicle> (service.deleteVehicle(vehicleId),HttpStatus.OK);
	}
	
	@PostMapping("/addVehicleDetails/{vehicleId}")
	public ResponseEntity<VehicleDetails> addVehicleDetails(@PathVariable String vehicleId, @RequestBody VehicleDetails vehicleDetails) throws VehicleInvalidException{
		return new ResponseEntity<>(service.addVehicleDetails(vehicleId, vehicleDetails),HttpStatus.OK);
	}
}
