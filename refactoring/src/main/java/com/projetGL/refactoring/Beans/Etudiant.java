package com.projetGL.refactoring.Beans;

import com.projetGL.refactoring.authentification.Beans.User;
import com.projetGL.refactoring.models.EtudiantDto;
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

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private User user;


    public Etudiant(EtudiantDto etudiant) {
        this.matricule = etudiant.getMatricule();
        this.niveauEtude = etudiant.getNiveau();
        this.user = etudiant.getUser();
    }
}