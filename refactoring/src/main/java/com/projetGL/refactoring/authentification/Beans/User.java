package com.projetGL.refactoring.authentification.Beans;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.projetGL.refactoring.authentification.models.RegisterRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String nom;

    private String prenom;
    private String numeroCNI;
    private String numeroTelephone;

    @JsonIgnore
    @Column(nullable = false)
    private String password;

    private String adresse;

    @ManyToOne
    @JoinColumn(name = "idRole")
    private Role roles;

    @CreationTimestamp
    @Column(updatable = false, name = "created_at")
    private Date createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Date updatedAt;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public User(RegisterRequest register){
        this.email = register.getEmail();
        this.nom = register.getNom();
        this.prenom = register.getPrenom();
        this.numeroCNI = register.getNumeroCNI();
        this.numeroTelephone = register.getNumeroTelephone();
        this.password = register.getPassword();
        this.adresse = register.getAdresse();
        this.roles = register.getRole();
    }
    public User(String mail, String admin, String admin1, String kit156, String number, String password, String dschang, Role userRole) {
        this.email = mail;
        this.nom = admin;
        this.prenom = admin1;
        this.numeroCNI = kit156;
        this.numeroTelephone = number;
        this.password = password;
        this.adresse = dschang;
        this.roles = userRole;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setId(Long id) {
        this.id = id;
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

    public void setRoles(Role roles) {
        this.roles = roles;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getNumeroCNI() {
        return numeroCNI;
    }

    public String getNumeroTelephone() {
        return numeroTelephone;
    }

    public String getAdresse() {
        return adresse;
    }

    public Role getRoles() {
        return roles;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }
}
