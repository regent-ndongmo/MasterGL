package com.projetGL.refactoring.Controller;

import com.projetGL.refactoring.Beans.Etudiant;
import com.projetGL.refactoring.Services.EtudiantService;
import com.projetGL.refactoring.models.EtudiantDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/etudiant")
@CrossOrigin(origins = "http://localhost:4200")
public class EtudiantController {

    private final EtudiantService etudiantService;
    public EtudiantController(EtudiantService etudiantService) {
        this.etudiantService = etudiantService;
    }

    @PostMapping("/create")
    public ResponseEntity<Etudiant> createEtudiant(@RequestBody EtudiantDto etudiant) {
        Etudiant etudiant1 = etudiantService.createEtudiant(etudiant);
        return ResponseEntity.ok(etudiant1);
    }

    @PutMapping("/updateStudent")
    public ResponseEntity<Etudiant> updateEtudiant(@RequestBody EtudiantDto etudiant) {
        Etudiant etudiant1 = etudiantService.updateEtudiant(etudiant);
        return ResponseEntity.ok(etudiant1);
    }

    @GetMapping("/")
    public ResponseEntity<List<Etudiant>> getAllEtudiants() {
        List<Etudiant> etudiants = etudiantService.getAllEtudiants();
        return ResponseEntity.ok(etudiants);
    }

    @GetMapping("/ById")
    public ResponseEntity<Etudiant> getEtudiantById(@RequestParam Long id) {
        Etudiant etudiant = etudiantService.getEtudiantById(id);
        return ResponseEntity.ok(etudiant);
    }

    @DeleteMapping("/delete")
    public Boolean deleteEtudiantById(@RequestParam Long id) {
        Boolean result = etudiantService.deleteEtudiantById(id);
        return result;
    }
}
