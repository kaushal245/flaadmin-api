package com.webelement.flaadmin.Exceptions;

@SuppressWarnings("serial")
public class InvalidRequestException extends RuntimeException {
	public InvalidRequestException(String message) {
		super(message);
	}
}
