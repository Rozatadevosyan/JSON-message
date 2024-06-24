package com.kafka.exceptions;

public class ApiException extends RuntimeException {
    public ApiException(String errorMessage) {
        super(errorMessage);
    }
 }
