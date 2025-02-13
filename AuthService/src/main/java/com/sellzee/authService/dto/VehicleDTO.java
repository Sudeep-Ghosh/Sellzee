package com.sellzee.authService.dto;

import org.springframework.data.mongodb.core.mapping.MongoId;

import com.sellzee.authService.model.VehicleDetails;

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
