package com.aluracursos.screenmatch.exception;

public class conversionErrorinRuntimeException extends RuntimeException {
    private String message;
    public conversionErrorinRuntimeException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
