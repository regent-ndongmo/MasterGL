package com.projetGL.refactoring.Beans;

import com.projetGL.refactoring.authentification.Beans.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Etudiant extends User {

    @Column(nullable = false)
    private String matricule;

    @Column(nullable = false)
    private String niveauEtude;

    @ManyToOne
    @JoinColumn(name = "filiere_id")
    private Filiere filiere;
}