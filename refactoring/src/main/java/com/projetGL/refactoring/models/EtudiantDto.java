package com.projetGL.refactoring.models;

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

}
