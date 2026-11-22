package com.webelement.flaadmin.Exceptions;

@SuppressWarnings("serial")
public class DuplicateTitleException extends RuntimeException {
    public DuplicateTitleException(String message) {
        super(message);
    }
}