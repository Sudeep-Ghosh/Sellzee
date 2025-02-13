package com.sellzee.authService.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehicleDetails {
	private String vdId;
	private String sellerName;
	private String mfgYear;
	private String registrationYear;
	private String regNumber;
	private String insurance;
	private String transmission;
	private String kmDriven;
}
