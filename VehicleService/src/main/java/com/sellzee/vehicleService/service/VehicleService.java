package com.sellzee.vehicleService.service;

import java.util.List;

import com.sellzee.vehicleService.dto.VehicleDTO;
import com.sellzee.vehicleService.exception.VehicleInvalidException;
import com.sellzee.vehicleService.model.Vehicle;
import com.sellzee.vehicleService.model.VehicleDetails;

public interface VehicleService {
	Vehicle addVehicle(Vehicle vehicle);
	Vehicle updateVehicle(VehicleDTO vehicle, String vehicleId) throws VehicleInvalidException;
	Vehicle getVehicleById(String vehicleId)throws VehicleInvalidException;
	List<Vehicle> getAllVehicles()throws VehicleInvalidException;
	Vehicle deleteVehicle(String vehicleId)throws VehicleInvalidException;
	VehicleDetails addVehicleDetails(String vehicleId, VehicleDetails vehicleDetails) throws VehicleInvalidException;
}
