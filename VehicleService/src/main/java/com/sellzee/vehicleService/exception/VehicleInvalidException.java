package com.sellzee.vehicleService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.NoArgsConstructor;

@NoArgsConstructor
@ResponseStatus(HttpStatus.NOT_FOUND)
public class VehicleInvalidException extends Exception{
	public VehicleInvalidException(String msg) {
		super(msg);
	}
}
