package com.example.demo.controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.stereotype.Controller;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.model.Professeur;
import com.example.demo.service.ProfesseurService;
import com.example.demo.dto.ProfesseurDTO;
import com.example.demo.mapper.ProfesseurMapper;



import java.util.*;

@RequestMapping("/professeurs")
@Controller
public class ProfesseurController {
    private final ProfesseurService professeurService;

    public ProfesseurController(ProfesseurService professeurService) {
        this.professeurService = professeurService;
    }

    @GetMapping("")
    public ResponseEntity<List<ProfesseurDTO>> getAllProfesseurs() {

        List<Professeur> professeurs = professeurService.getAllProfesseurs();
        List<ProfesseurDTO> professeursDtos = ProfesseurMapper.toProfesseurDTOList(professeurs);

        return ResponseEntity.ok(professeursDtos);
    }

    @GetMapping("/{professeurId}")
    public ResponseEntity<ProfesseurDTO> getProfesseurById(@PathVariable Integer professeurId) {

        Professeur professeur = professeurService.getProfesseurById(professeurId);

        if (professeur == null) {
            return ResponseEntity.notFound().build();
        } 
        ProfesseurDTO dto = ProfesseurMapper.toProfesseurDTO(professeur);
        return ResponseEntity.ok(dto);
    }

    @PostMapping("")
    public ResponseEntity<ProfesseurDTO> createProfesseur(@RequestBody ProfesseurDTO dto) {
        Professeur fromDto = ProfesseurMapper.toProfesseur(dto);
        Professeur createdProfesseur = professeurService.createProfesseur(fromDto);
        if (createdProfesseur == null) {
            return ResponseEntity.badRequest().build();
        }
        ProfesseurDTO createdProfesseurDto = ProfesseurMapper.toProfesseurDTO(createdProfesseur);
        return ResponseEntity.ok(createdProfesseurDto);
    }

    @DeleteMapping("/{professeurId}")
    public ResponseEntity<Professeur> deleteProfesseurById(@PathVariable Integer professeurId) {
        professeurService.deleteProfesseur(professeurId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    
}