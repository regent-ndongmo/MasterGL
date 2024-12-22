package com.projetGL.refactoring.Services.impl;

import com.projetGL.refactoring.Beans.Etudiant;
import com.projetGL.refactoring.Repository.EtudiantRepository;
import com.projetGL.refactoring.Services.EtudiantService;
import com.projetGL.refactoring.authentification.Beans.Role;
import com.projetGL.refactoring.authentification.Beans.User;
import com.projetGL.refactoring.authentification.Repository.RoleRepository;
import com.projetGL.refactoring.authentification.Repository.UserRepository;
import com.projetGL.refactoring.models.EtudiantDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class EtudiantServiceImplTest {

    @Mock
    private EtudiantService etudiantService;

    @InjectMocks
    private EtudiantServiceImpl etudiantServiceImpl;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private RoleRepository roleRepository;

    @Mock
    private EtudiantRepository etudiantRepository;

    @Mock
    private UserRepository userRepository;

    private EtudiantDto etudiantDto1;
    private EtudiantDto etudiantDto2;
    private User user;
    private User user1;
    private Role role;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        // Initialiser le rôle
        role = new Role();
        role.setRoleName("ROLE_USER");

        // Mocker le comportement de roleRepository.findByRoleName
        when(roleRepository.findByRoleName(anyString())).thenReturn(Optional.of(role));

        user = new User(1L, "admin@test.com", "admin", "admin", "kit156", "657730825", passwordEncoder.encode("password"), "Dschang", role);
        user1 = new User(2L, "jauress@test.com", "admin", "admin", "kit156", "657730825", passwordEncoder.encode("password"), "Dschang", role);

        etudiantDto1 = new EtudiantDto(1L, "12345", "niveau 1", user);
        etudiantDto2 = new EtudiantDto(2L, "67890", "niveau 2", user1);
    }

    @Test
    void createEtudiant() {
        when(userRepository.findByIdOrNull(user.getId())).thenReturn(user);

        Etudiant expectedEtudiant = new Etudiant(etudiantDto1);
        expectedEtudiant.setMatricule("GL12345");
        expectedEtudiant.setUser(user);
        when(etudiantRepository.save(any(Etudiant.class))).thenReturn(expectedEtudiant);

        Etudiant createdEtudiant = etudiantServiceImpl.createEtudiant(etudiantDto1);

        assertNotNull(createdEtudiant);
        assertEquals(etudiantDto1.getNiveau(), createdEtudiant.getNiveauEtude());
        assertEquals(user, createdEtudiant.getUser());
        assertEquals("GL12345", createdEtudiant.getMatricule());
    }

    @Test
    void getAllEtudiants() {
        Etudiant etudiant1 = new Etudiant(etudiantDto1);
        Etudiant etudiant2 = new Etudiant(etudiantDto2);
        when(etudiantRepository.findAll()).thenReturn(Arrays.asList(etudiant1, etudiant2));

        List<Etudiant> etudiants = etudiantServiceImpl.getAllEtudiants();
        assertNotNull(etudiants);
        assertEquals(2, etudiants.size());
    }

    @Test
    void getEtudiantById() {
        Etudiant etudiant = new Etudiant(etudiantDto1);
        when(etudiantRepository.findByIdOrNull(1L)).thenReturn(etudiant);

        Etudiant foundEtudiant = etudiantServiceImpl.getEtudiantById(1L);
        assertNotNull(foundEtudiant);
        assertEquals(etudiantDto1.getNiveau(), foundEtudiant.getNiveauEtude());
    }

    @Test
    void deleteEtudiantById() {
        Etudiant etudiant = new Etudiant(etudiantDto1);
        when(etudiantRepository.findByIdOrNull(1L)).thenReturn(etudiant);
        doNothing().when(etudiantRepository).delete(etudiant);

        boolean result = etudiantServiceImpl.deleteEtudiantById(1L);
        assertTrue(result);
        verify(etudiantRepository, times(1)).delete(etudiant);
    }

    @Test
    void updateEtudiant() {
        Etudiant existingEtudiant = new Etudiant(etudiantDto1);
        when(etudiantRepository.findByIdOrNull(etudiantDto1.getId())).thenReturn(existingEtudiant);

        Etudiant updatedEtudiant = new Etudiant(etudiantDto1);
        updatedEtudiant.setMatricule(existingEtudiant.getMatricule());
        when(etudiantRepository.save(any(Etudiant.class))).thenReturn(updatedEtudiant);

        Etudiant result = etudiantServiceImpl.updateEtudiant(etudiantDto1);
        assertNotNull(result);
        assertEquals(etudiantDto1.getMatricule(), result.getMatricule());
    }
}