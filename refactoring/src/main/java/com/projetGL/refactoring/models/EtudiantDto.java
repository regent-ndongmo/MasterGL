package com.projetGL.refactoring.models;

import com.projetGL.refactoring.Beans.Filiere;
import com.projetGL.refactoring.authentification.Beans.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class EtudiantDto {

    private Long id;
    private String matricule;
    private String niveau;
    private User user;
    private Filiere filiere;

    public EtudiantDto(long l, String number, String s, Object o) {
        this.id = l;
        this.matricule = number;
        this.niveau = s;
        this.user = (User) o;
        this.filiere = (Filiere) o;
    }
}
