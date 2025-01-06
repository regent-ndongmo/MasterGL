package com.projetGL.refactoring.Services.impl;

import com.projetGL.refactoring.Beans.Etudiant;
import com.projetGL.refactoring.Beans.Filiere;
import com.projetGL.refactoring.Repository.EtudiantRepository;
import com.projetGL.refactoring.Repository.FiliereRepository;
import com.projetGL.refactoring.Services.EtudiantService;
import com.projetGL.refactoring.authentification.Beans.User;
import com.projetGL.refactoring.authentification.Repository.UserRepository;
import com.projetGL.refactoring.models.EtudiantDto;
import com.projetGL.refactoring.util.MatriculeGenerator;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EtudiantServiceImpl implements EtudiantService {

    private final EtudiantRepository etudiantRepository;
    private final UserRepository userRepository;
    private final FiliereRepository filiereRepository;

    public EtudiantServiceImpl(EtudiantRepository etudiantRepository, UserRepository userRepository, FiliereRepository filiereRepository) {
        this.etudiantRepository = etudiantRepository;
        this.userRepository = userRepository;
        this.filiereRepository = filiereRepository;
    }

    @Override
    public Etudiant createEtudiant(EtudiantDto etudiant) {
        User user = userRepository.findByIdOrNull(etudiant.getUser().getId());
        Filiere filiere = filiereRepository.findByIdOrNull(etudiant.getFiliere().getId());
        Etudiant newEtudiant = new Etudiant(etudiant);
        newEtudiant.setMatricule(MatriculeGenerator.generateMatricule("GL"));
        newEtudiant.setFiliere(filiere);
        newEtudiant.setUser(user);
        return etudiantRepository.save(newEtudiant);
    }

    @Override
    public List<Etudiant> getAllEtudiants() {
        return etudiantRepository.findAll();
    }

    @Override
    public Etudiant getEtudiantById(Long id) {
        return etudiantRepository.findByIdOrNull(id);
    }

    @Override
    public boolean deleteEtudiantById(Long id) {
        Etudiant etudiant = etudiantRepository.findByIdOrNull(id);
        try {
            etudiantRepository.delete(etudiant);
            return true;
        }
        catch (Exception e) {
            return false;
        }

    }

    @Override
    public Etudiant updateEtudiant(EtudiantDto etudiant) {
        try {
            Etudiant etudiant1 = etudiantRepository.findByIdOrNull(etudiant.getId());
            if (etudiant1 != null) {
                Etudiant etudiant2 = new Etudiant(etudiant);
                etudiant2.setMatricule(etudiant1.getMatricule());
                return etudiantRepository.save(etudiant2);
            }
        }
        catch (Exception e) {
            return null;
        }
        return null;
    }
}
