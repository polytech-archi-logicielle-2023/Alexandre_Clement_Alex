package com.example.demo.service;
import org.springframework.stereotype.Service;
import com.example.demo.model.Cours;
import com.example.demo.repository.CoursRepository;

import java.util.*;

@Service
public class CoursService {
    private final CoursRepository repository;
    public List<Cours> list = new ArrayList<>();
    public Integer id = 1;
    public CoursService(CoursRepository repository) {
        this.repository = repository;
        this.initCours();
    }
    public void initCours() {
        Cours cours1 = new Cours();
        cours1.setNom_du_cours("cours1");
        cours1.setEnseignant("Dupont");
        cours1.setType("TD");


        Cours cours2 = new Cours();
        cours2.setNom_du_cours("cours2");
        cours2.setEnseignant("Dupond");
        cours2.setType("TP");

        this.repository.save(cours1);
        this.repository.save(cours2);
    }

    public List<Cours> getAllCours() {
        return this.repository.findAll();
    }

    public Cours getCoursById(Integer id) {

        Optional<Cours> found = this.repository.findById(id);

        if (found.isPresent()) {
            return found.get();
        }
        return null;
    }

    public Cours createCours(Cours givenCours) {

        if (givenCours.getNom_du_cours() != null && givenCours.getEnseignant() != null && givenCours.getType() != null) {
            return this.repository.save(givenCours);
        }
        return null;
    }
    public boolean deleteCours(Integer coursId) {
        Cours found = getCoursById(coursId);
        if (found != null) {
            this.repository.deleteById(found.getId());
            return true;
        }
        return false;
    }
}