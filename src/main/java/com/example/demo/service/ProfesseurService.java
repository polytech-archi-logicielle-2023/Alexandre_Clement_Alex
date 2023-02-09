package com.example.demo.service;
import org.springframework.stereotype.Service;
import com.example.demo.model.Professeur;
import com.example.demo.repository.ProfesseurRepository;

import java.util.*;

@Service
public class ProfesseurService {
    private final ProfesseurRepository repository;
    public List<Professeur> list = new ArrayList<>();
    public Integer id = 1;
    public ProfesseurService(ProfesseurRepository repository) {
        this.repository = repository;
        this.initProfesseur();
    }
    public void initProfesseur() {
        Professeur prof1 = new Professeur();
        prof1.setName("alexandre");
        prof1.setSurname("gros fdp");
        prof1.setCourse("salop");

        Professeur prof2 = new Professeur();
        prof2.setName("alexandre est ");
        prof2.setSurname("un enorme gros fdp");
        prof2.setCourse("et une petite salope");

        this.repository.save(prof1);
        this.repository.save(prof2);
    }

    public List<Professeur> getAllProfesseurs() {
        return this.repository.findAll();
    }

    public Professeur getProfesseurById(Integer id) {

        Optional<Professeur> found = this.repository.findById(id);

        if (found.isPresent()) {
            return found.get();
        }
        return null;
    }

    public Professeur createProfesseur(Professeur givenProfesseur) {

        if (givenProfesseur.getName() != null && givenProfesseur.getSurname() != null && givenProfesseur.getCourse() != null) {
            return this.repository.save(givenProfesseur);
        }
        return null;
    }
    public boolean deleteProfesseur(Integer professeurId) {
        Professeur found = getProfesseurById(professeurId);
        if (found != null) {
            this.repository.deleteById(found.getId());
            return true;
        }
        return false;
    }
}