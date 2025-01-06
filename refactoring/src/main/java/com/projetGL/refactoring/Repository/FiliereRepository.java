package com.projetGL.refactoring.Repository;

import com.projetGL.refactoring.Beans.Filiere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FiliereRepository extends JpaRepository<Filiere, Long> {

    @Query("SELECT p FROM Filiere p WHERE p.id = ?1")
    Filiere findByIdOrNull(Long filiereId);
}
