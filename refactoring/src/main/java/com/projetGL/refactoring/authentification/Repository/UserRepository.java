package com.projetGL.refactoring.authentification.Repository;

import com.projetGL.refactoring.Beans.Etudiant;
import com.projetGL.refactoring.authentification.Beans.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);

    @Query("SELECT p FROM User p WHERE p.id = ?1")
    public User findByIdOrNull(Long id);

}
