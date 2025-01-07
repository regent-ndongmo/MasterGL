package com.projetGL.refactoring.DBinit;

import com.projetGL.refactoring.Beans.Faculte;
import com.projetGL.refactoring.Beans.Filiere;
import com.projetGL.refactoring.Beans.Universite;
import com.projetGL.refactoring.Repository.FacultyRepository;
import com.projetGL.refactoring.Repository.FiliereRepository;
import com.projetGL.refactoring.Repository.UniversityRepository;
import org.aspectj.runtime.reflect.Factory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class dbInitilizer implements CommandLineRunner {

    private final UniversityRepository universityRepository;
    private final FacultyRepository facultyRepository;
    private final FiliereRepository filiereRepository;

    public dbInitilizer(UniversityRepository universityRepository, FacultyRepository facultyRepository, FiliereRepository filiereRepository) {
        this.universityRepository = universityRepository;
        this.facultyRepository = facultyRepository;
        this.filiereRepository = filiereRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (universityRepository.count() == 0) {
            Universite universite1 = new Universite("Universite de Dschang", "Dschang, Ouest, Cameroun");
            Universite universite2 = new Universite("Universite de Douala", "Douala, Littoral, Cameroun");
            universityRepository.save(universite1);
            universityRepository.save(universite2);
        }

        if(facultyRepository.count() == 0) {
            Universite universite = universityRepository.findById(1L).get();
            Faculte faculte = new Faculte("Faculte des sciences", universite);
            Faculte faculte1 = new Faculte("Faculte des lettres", universite);
            facultyRepository.save(faculte);
            facultyRepository.save(faculte1);
        }
        if(filiereRepository.count() == 0) {
            Faculte faculte = facultyRepository.findById(1L).get();
            Filiere filiere = new Filiere("Informatique", faculte);
            Filiere filiere1 = new Filiere("Mathematique", faculte);
            filiereRepository.save(filiere);
            filiereRepository.save(filiere1);

        }

    }

}
