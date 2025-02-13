package com.sellzee.vehicleService.dto;

import org.springframework.data.mongodb.core.mapping.MongoId;

import com.sellzee.vehicleService.model.VehicleDetails;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehicleDTO {
	@MongoId
	private String vehicleId;
	private String vehicleName;
	private String price;
	private String address;
	private VehicleDetails details;
}
