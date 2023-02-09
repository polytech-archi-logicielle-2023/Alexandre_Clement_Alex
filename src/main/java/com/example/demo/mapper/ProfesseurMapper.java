package com.example.demo.mapper;

import com.example.demo.dto.ProfesseurDTO;
import com.example.demo.model.Professeur;

import java.util.*;

public class ProfesseurMapper {

    public static ProfesseurDTO toProfesseurDTO(Professeur professeur) {
        return ProfesseurDTO.builder()
                .name(professeur.getName())
                .surname(professeur.getSurname())
                .course(professeur.getCourse())
                .build();
    }

    public static List<ProfesseurDTO> toProfesseurDTOList(List<Professeur> list) {
        List<ProfesseurDTO> dtoList = new ArrayList<>();
        for (Professeur professeur : list) {
            dtoList.add(toProfesseurDTO(professeur));
        }
        return dtoList;
    }

    public static Professeur toProfesseur(ProfesseurDTO dto) {
        return Professeur.builder()
                .name(dto.getName())
                .surname(dto.getSurname())
                .course(dto.getCourse())
                .build();
    }

    public static List<Professeur> toProfesseurList(List<ProfesseurDTO> list) {
        List<Professeur> professeurList = new ArrayList<>();
        for (ProfesseurDTO dto : list) {
            professeurList.add(toProfesseur(dto));
        }
        return professeurList;
    }

}
