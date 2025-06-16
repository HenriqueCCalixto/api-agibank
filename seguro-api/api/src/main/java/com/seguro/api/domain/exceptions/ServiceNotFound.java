package com.seguro.api.domain.exceptions;

public class ServiceNotFound extends RuntimeException {
    public ServiceNotFound(String message) {
        super(message);
    }
}
