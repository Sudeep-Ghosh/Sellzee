package com.sellzee.adminService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.NoArgsConstructor;

@NoArgsConstructor
@ResponseStatus(HttpStatus.NOT_FOUND)
public class AdminException extends Exception{
	public AdminException(String msg) {
		super(msg);
	}
}
