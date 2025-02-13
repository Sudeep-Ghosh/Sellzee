package com.sellzee.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.NoArgsConstructor;

@NoArgsConstructor
@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserInvalidException extends Exception{
	public UserInvalidException(String msg) {
		super(msg);
	}
}
