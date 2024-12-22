package com.projetGL.refactoring.Services;

import com.projetGL.refactoring.Beans.Etudiant;
import com.projetGL.refactoring.models.EtudiantDto;

import java.util.List;

public interface EtudiantService {

    public Etudiant createEtudiant(EtudiantDto etudiant);
    public List<Etudiant> getAllEtudiants();
    public Etudiant getEtudiantById(Long id);
    public boolean deleteEtudiantById(Long id);
    public Etudiant updateEtudiant(EtudiantDto etudiant);
}
