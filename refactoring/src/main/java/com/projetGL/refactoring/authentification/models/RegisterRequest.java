package com.projetGL.refactoring.authentification.models;

import com.projetGL.refactoring.authentification.Beans.Role;

public class RegisterRequest {
    private String email;
    private String nom;
    private String prenom;
    private String numeroCNI;
    private String numeroTelephone;
    private String password;
    private String adresse;
    private Role role;

    public RegisterRequest() {}

    public RegisterRequest(String email, String nom, String prenom, String numeroCNI, String numeroTelephone, String password, String adresse, Role role) {
        this.email = email;
        this.nom = nom;
        this.prenom = prenom;
        this.numeroCNI = numeroCNI;
        this.numeroTelephone = numeroTelephone;
        this.password = password;
        this.adresse = adresse;
        this.role = role;
    }

    public Role getRole() {
        return role;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getPassword() {
        return password;
    }

    public String getNumeroTelephone() {
        return numeroTelephone;
    }

    public String getNumeroCNI() {
        return numeroCNI;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getNom() {
        return nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setNumeroCNI(String numeroCNI) {
        this.numeroCNI = numeroCNI;
    }

    public void setNumeroTelephone(String numeroTelephone) {
        this.numeroTelephone = numeroTelephone;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}