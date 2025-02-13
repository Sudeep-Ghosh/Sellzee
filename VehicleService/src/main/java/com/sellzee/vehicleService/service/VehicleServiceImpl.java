package com.sellzee.vehicleService.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sellzee.vehicleService.clients.UserClient;
import com.sellzee.vehicleService.dto.VehicleDTO;
import com.sellzee.vehicleService.exception.VehicleInvalidException;
import com.sellzee.vehicleService.model.User;
import com.sellzee.vehicleService.model.Vehicle;
import com.sellzee.vehicleService.model.VehicleDetails;
import com.sellzee.vehicleService.repository.VehicleDetailsRepository;
import com.sellzee.vehicleService.repository.VehicleRepository;

@Service
public class VehicleServiceImpl implements VehicleService {

	@Autowired
	private VehicleRepository vehicleRepository; 
	
	@Autowired
	private VehicleDetailsRepository vehicleDetailsRepository;
	
	@Autowired
	private UserClient userClient;
	
	@Override
	public Vehicle addVehicle(Vehicle vehicle) {
		// TODO Auto-generated method stub
		return vehicleRepository.save(vehicle);
	}

	@Override
	public Vehicle updateVehicle(VehicleDTO vehicle, String vehicleId) throws VehicleInvalidException {
		// TODO Auto-generated method stub
		Optional<Vehicle> optVehicle = vehicleRepository.findById(vehicleId);
		if(optVehicle.isPresent()) {
			
			Vehicle existingVehicle = optVehicle.get();
			
			if(vehicle.getVehicleName()!=null) {
				existingVehicle.setVehicleName(vehicle.getVehicleName());
			}
			if(vehicle.getPrice()!=null) {
				existingVehicle.setPrice(vehicle.getPrice());
			}
			if(vehicle.getAddress()!=null) {
				existingVehicle.setAddress(vehicle.getAddress());
			}
			if(vehicle.getDetails()!=null) {
				existingVehicle.setDetails(vehicle.getDetails());
			}
			return vehicleRepository.save(existingVehicle);
		}
		else {
			throw new VehicleInvalidException("Invalid Vehicle details");
		}
		
	}

	@Override
	public Vehicle getVehicleById(String vehicleId) throws VehicleInvalidException {
		// TODO Auto-generated method stub
		Optional<Vehicle> optVehicle = vehicleRepository.findById(vehicleId);
		if(optVehicle.isPresent()) {
			Vehicle vehicle = optVehicle.get();
			return vehicle;
		}
		else {
			throw new VehicleInvalidException("Invalid Vehicle ID!");
		}
	}

	@Override
	public List<Vehicle> getAllVehicles() throws VehicleInvalidException {
		// TODO Auto-generated method stub
		List<Vehicle> list =  vehicleRepository.findAll();
		if(list.isEmpty()) {
			throw new VehicleInvalidException("No Vehicle Details Available");
		}
		else {
			return list;
		}
	}

	@Override
	public Vehicle deleteVehicle(String vehicleId) throws VehicleInvalidException {
		// TODO Auto-generated method stub
		Optional<Vehicle> optVehicle = vehicleRepository.findById(vehicleId);
		if(optVehicle.isPresent()) {
			Vehicle vehicle = optVehicle.get();
			vehicleRepository.deleteById(vehicleId);
			return vehicle;
		}
		else {
			throw new VehicleInvalidException("Invalid Vehicle Details");
		}
	}

	@Override
	public VehicleDetails addVehicleDetails(String vehicleId, VehicleDetails vehicleDetails) throws VehicleInvalidException {
		// TODO Auto-generated method stub
		Optional<Vehicle> optVehicle = vehicleRepository.findById(vehicleId);
		if(optVehicle.isPresent()) {
			vehicleDetails = vehicleDetailsRepository.save(vehicleDetails);
			Vehicle vehicle = optVehicle.get();
			vehicle.setDetails(vehicleDetails);
			vehicleRepository.save(vehicle);
		}else {
			throw new VehicleInvalidException("Vehicle Not Found!!");
		}
		return null;
	}

}
