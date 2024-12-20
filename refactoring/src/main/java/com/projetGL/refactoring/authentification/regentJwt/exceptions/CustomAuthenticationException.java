package com.projetGL.refactoring.authentification.regentJwt.exceptions;

public class CustomAuthenticationException extends RuntimeException {
    public CustomAuthenticationException(String message, Throwable cause) {
        super(message, cause);
    }
}
