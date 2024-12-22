package com.projetGL.refactoring.Controller;

import com.projetGL.refactoring.Beans.Etudiant;
import com.projetGL.refactoring.Services.EtudiantService;
import com.projetGL.refactoring.models.EtudiantDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Arrays;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


class EtudiantControllerTest {

    @Mock
    private EtudiantService etudiantService;

    @InjectMocks
    private EtudiantController etudiantController;

    private MockMvc mockMvc;

    private EtudiantDto etudiantDto1;
    private EtudiantDto etudiantDto2;
    private Etudiant etudiant1;
    private Etudiant etudiant2;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(etudiantController).build();

        etudiantDto1 = new EtudiantDto(1L, "12345", "niveau 1", null);
        etudiantDto2 = new EtudiantDto(2L, "67890", "niveau 2", null);
        etudiant1 = new Etudiant(etudiantDto1);
        etudiant2 = new Etudiant(etudiantDto2);
    }

    @Test
    void createEtudiant() throws Exception {
        when(etudiantService.createEtudiant(any(EtudiantDto.class))).thenReturn(etudiant1);

        mockMvc.perform(post("/etudiant/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(etudiantDto1)))
                .andExpect(status().isOk());
    }

    @Test
    void updateEtudiant() throws Exception {
        when(etudiantService.updateEtudiant(any(EtudiantDto.class))).thenReturn(etudiant1);

        mockMvc.perform(put("/etudiant/updateStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(etudiantDto1)))
                .andExpect(status().isOk());
    }

    @Test
    void getAllEtudiants() throws Exception {
        when(etudiantService.getAllEtudiants()).thenReturn(Arrays.asList(etudiant1, etudiant2));

        mockMvc.perform(get("/etudiant/"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2));
    }

    @Test
    void getEtudiantById() throws Exception {
        when(etudiantService.getEtudiantById(1L)).thenReturn(etudiant1);

        mockMvc.perform(get("/etudiant/ById")
                        .param("id", "1"))
                .andExpect(status().isOk());
    }

    @Test
    void deleteEtudiantById() throws Exception {
        when(etudiantService.deleteEtudiantById(1L)).thenReturn(true);

        mockMvc.perform(delete("/etudiant/delete")
                        .param("id", "1"))
                .andExpect(status().isOk())
                .andExpect(content().string("true"));
    }

    private static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}