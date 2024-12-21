package com.projetGL.refactoring.authentification.Repository;

import com.projetGL.refactoring.authentification.Beans.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByRoleName(String roleName);

    @Query("SELECT u FROM Role u WHERE u.id = :id")
    Optional<Role> findByIdOrNull(Long id);
}
