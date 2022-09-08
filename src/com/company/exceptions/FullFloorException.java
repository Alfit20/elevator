package com.company.exceptions;

public class FullFloorException extends RuntimeException {
    private String message;

    public FullFloorException(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
