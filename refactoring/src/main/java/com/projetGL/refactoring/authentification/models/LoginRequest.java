package com.projetGL.refactoring.authentification.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class LoginRequest {
    
    private final String email;

    private final String password;

}
