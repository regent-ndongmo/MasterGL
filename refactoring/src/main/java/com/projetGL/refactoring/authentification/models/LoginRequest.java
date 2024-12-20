package com.projetGL.refactoring.authentification.models;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class LoginRequest {
    
    private final String email;

    private final String password;

    public LoginRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
}
