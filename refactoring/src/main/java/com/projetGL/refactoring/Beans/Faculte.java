package com.projetGL.refactoring.Beans;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Faculte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nom;

    @ManyToOne
    @JoinColumn(name = "universite_id")
    private Universite universite;

    public Faculte(String faculteDesScience, Universite universite) {
        this.nom = faculteDesScience;
        this.universite = universite;
    }
}
