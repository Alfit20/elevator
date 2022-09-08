package com.company.exceptions;

public class FullElevatorException extends RuntimeException {
    private String message;

    public FullElevatorException(String message) {
        this.message = message;
    }
}
