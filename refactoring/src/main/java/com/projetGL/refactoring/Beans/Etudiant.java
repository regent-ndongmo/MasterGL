package com.projetGL.refactoring.Beans;

import com.projetGL.refactoring.authentification.Beans.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Etudiant{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String matricule;

    @Column(nullable = false)
    private String niveauEtude;

    @ManyToOne
    @JoinColumn(name = "filiere_id")
    private Filiere filiere;


}