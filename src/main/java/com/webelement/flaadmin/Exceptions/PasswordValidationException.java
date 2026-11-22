package com.webelement.flaadmin.Exceptions;

@SuppressWarnings("serial")
public class PasswordValidationException extends RuntimeException {
	public PasswordValidationException(String message) {
		super(message);
	}

	public PasswordValidationException(String message, Throwable cause) {
		super(message, cause);
	}
}
