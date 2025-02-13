package com.sellzee.authService.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle {
	private String vehicleId;
	private String vehicleName;
	private String price;
	private String address;
	private VehicleDetails details;
	private String sellerId;
}
