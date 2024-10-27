package com.betek.gym.exceptionhandler;

public class ApprenticeNotFoundException extends RuntimeException {
    public ApprenticeNotFoundException(String message) {
        super(message);
    }
}