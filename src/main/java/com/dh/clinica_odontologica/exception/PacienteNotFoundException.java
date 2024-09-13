package com.dh.clinica_odontologica.exception;

public class PacienteNotFoundException extends RuntimeException {
    public PacienteNotFoundException(String message) {
        super(message);
    }
}
