package com.projetGL.refactoring.Beans;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Universite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long universiteId;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private String adresse;
}