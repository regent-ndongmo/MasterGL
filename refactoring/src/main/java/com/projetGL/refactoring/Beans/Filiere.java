package com.projetGL.refactoring.Beans;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Filiere {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nom;

    @ManyToOne
    @JoinColumn(name = "faculte_id")
    private Faculte faculte;

    public Filiere(String informatique, Faculte faculte) {
        this.nom = informatique;
        this.faculte = faculte;
    }
}
