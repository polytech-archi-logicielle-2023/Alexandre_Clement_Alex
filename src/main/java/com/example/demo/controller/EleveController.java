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

import com.example.demo.model.Eleve;
import com.example.demo.service.EleveService;
import com.example.demo.dto.EleveDTO;
import com.example.demo.mapper.EleveMapper;



import java.util.*;

@RequestMapping("/eleves")
@Controller
public class EleveController {
    private final EleveService eleveService;

    public EleveController(EleveService eleveService) {
        this.eleveService = eleveService;
    }

    @GetMapping("")
    public ResponseEntity<List<EleveDTO>> getAllEleves() {

        List<Eleve> eleves = eleveService.getAllEleves();
        List<EleveDTO> elevesDtos = EleveMapper.toEleveDTOList(eleves);

        return ResponseEntity.ok(elevesDtos);
    }

    @GetMapping("/{eleveId}")
    public ResponseEntity<EleveDTO> getEleveById(@PathVariable Integer eleveId) {

        Eleve eleve = eleveService.getEleveById(eleveId);

        if (eleve == null) {
            return ResponseEntity.notFound().build();
        } 
        EleveDTO dto = EleveMapper.toEleveDTO(eleve);
        return ResponseEntity.ok(dto);
    }

    @PostMapping("")
    public ResponseEntity<EleveDTO> createEleve(@RequestBody EleveDTO dto) {
        Eleve fromDto = EleveMapper.toEleve(dto);
        Eleve createdEleve = eleveService.createEleve(fromDto);
        if (createdEleve == null) {
            return ResponseEntity.badRequest().build();
        }
        EleveDTO createdEleveDto = EleveMapper.toEleveDTO(createdEleve);
        return ResponseEntity.ok(createdEleveDto);
    }

    @DeleteMapping("/{eleveId}")
    public ResponseEntity<Eleve> deleteEleveById(@PathVariable Integer eleveId) {
        eleveService.deleteEleve(eleveId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    
}