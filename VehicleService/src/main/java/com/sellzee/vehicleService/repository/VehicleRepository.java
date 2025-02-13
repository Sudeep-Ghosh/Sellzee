package com.sellzee.vehicleService.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.sellzee.vehicleService.model.Vehicle;

@Repository
public interface VehicleRepository extends MongoRepository<Vehicle, String> {

}
