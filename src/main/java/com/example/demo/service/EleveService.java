package com.example.demo.service;
import org.springframework.stereotype.Service;
import com.example.demo.model.Eleve;
import com.example.demo.repository.EleveRepository;

import java.util.*;

@Service
public class EleveService {
    private final EleveRepository repository;
    public List<Eleve> list = new ArrayList<>();
    public Integer id = 1;
    public EleveService(EleveRepository repository) {
        this.repository = repository;
        this.initEleves();
    }
    public void initEleves() {
        Eleve eleve1 = new Eleve();
        eleve1.setName("eleve1");
        eleve1.setSurname("surname1");
        eleve1.setFollowed_course("Français");

        Eleve eleve2 = new Eleve();
        eleve2.setName("eleve2");
        eleve2.setSurname("surname2");
        eleve2.setFollowed_course("Math");

        this.repository.save(eleve1);
        this.repository.save(eleve2);
    }

    public List<Eleve> getAllEleves() {
        return this.repository.findAll();
    }

    public Eleve getEleveById(Integer id) {

        Optional<Eleve> found = this.repository.findById(id);

        if (found.isPresent()) {
            return found.get();
        }
        return null;
    }

    public Eleve createEleve(Eleve givenEleve) {

        if (givenEleve.getName() != null && givenEleve.getSurname() != null && givenEleve.getFollowed_course() != null) {
            return this.repository.save(givenEleve);
        }
        return null;
    }
    public boolean deleteEleve(Integer eleveId) {
        Eleve found = getEleveById(eleveId);
        if (found != null) {
            this.repository.deleteById(found.getId());
            return true;
        }
        return false;
    }
}