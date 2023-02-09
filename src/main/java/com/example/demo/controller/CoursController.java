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

import com.example.demo.model.Cours;
import com.example.demo.service.CoursService;
import com.example.demo.dto.CoursDTO;
import com.example.demo.mapper.CoursMapper;



import java.util.*;

@RequestMapping("/cours")
@Controller
public class CoursController {
    private final CoursService coursService;

    public CoursController(CoursService coursService) {
        this.coursService = coursService;
    }

    @GetMapping("")
    public ResponseEntity<List<CoursDTO>> getAllCours() {

        List<Cours> cours = coursService.getAllCours();
        List<CoursDTO> coursDtos = CoursMapper.toCoursDTOList(cours);

        return ResponseEntity.ok(coursDtos);
    }

    @GetMapping("/{coursId}")
    public ResponseEntity<CoursDTO> getCoursById(@PathVariable Integer coursId) {

        Cours cours = coursService.getCoursById(coursId);

        if (cours == null) {
            return ResponseEntity.notFound().build();
        } 
        CoursDTO dto = CoursMapper.toCoursDTO(cours);
        return ResponseEntity.ok(dto);
    }

    @PostMapping("")
    public ResponseEntity<CoursDTO> createCours(@RequestBody CoursDTO dto) {
        Cours fromDto = CoursMapper.toCours(dto);
        Cours createdCours = coursService.createCours(fromDto);
        if (createdCours == null) {
            return ResponseEntity.badRequest().build();
        }
        CoursDTO createdCoursDto = CoursMapper.toCoursDTO(createdCours);
        return ResponseEntity.ok(createdCoursDto);
    }

    @DeleteMapping("/{coursId}")
    public ResponseEntity<Cours> deleteCoursById(@PathVariable Integer coursId) {
        coursService.deleteCours(coursId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    
}