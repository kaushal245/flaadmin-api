package com.webelement.flaadmin.Exceptions;

@SuppressWarnings("serial")
public class DuplicateTaskTitleException extends RuntimeException {
	public DuplicateTaskTitleException(String message) {
		super(message);
	}
}