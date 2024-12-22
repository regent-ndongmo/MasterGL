package com.projetGL.refactoring.Repository;

import com.projetGL.refactoring.Beans.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EtudiantRepository extends JpaRepository<Etudiant, Integer> {

    @Query("SELECT p FROM Etudiant p WHERE p.id = ?1")
    public Etudiant findByIdOrNull(Long id);

}
