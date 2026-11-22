package com.webelement.flaadmin.Exceptions;

public class InvalidCaptchaException  extends RuntimeException {
	public InvalidCaptchaException(String message) {
        super(message);
    }
}
