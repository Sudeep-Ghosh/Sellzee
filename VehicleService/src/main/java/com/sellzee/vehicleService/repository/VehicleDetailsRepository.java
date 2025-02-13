package com.sellzee.vehicleService.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.sellzee.vehicleService.model.VehicleDetails;

public interface VehicleDetailsRepository extends MongoRepository<VehicleDetails, String>{

}
