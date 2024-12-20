package com.projetGL.refactoring.authentification.models;

import com.projetGL.refactoring.authentification.Beans.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {
    private String email;
    private String nom;
    private String prenom;
    private String numeroCNI;
    private String numeroTelephone;
    private String password;
    private String adresse;
    private Role role;

}