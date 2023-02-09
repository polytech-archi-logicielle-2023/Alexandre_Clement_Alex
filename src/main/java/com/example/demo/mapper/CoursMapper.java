package com.example.demo.mapper;
import com.example.demo.dto.CoursDTO;
import com.example.demo.model.Cours;

import java.util.*;

public class CoursMapper {

    public static CoursDTO toCoursDTO(Cours cours) {
        return CoursDTO.builder()
                .Nom_du_cours(cours.getNom_du_cours())
                .Enseignant(cours.getEnseignant())
                .Type(cours.getType())
                .build();
    }

    public static List<CoursDTO> toCoursDTOList(List<Cours> list) {
        List<CoursDTO> dtoList = new ArrayList<>();
        for (Cours cours : list) {
            dtoList.add(toCoursDTO(cours));
        }
        return dtoList;
    }

    public static Cours toCours(CoursDTO dto) {
        return Cours.builder()
                .Nom_du_cours(dto.getNom_du_cours())
                .Enseignant(dto.getEnseignant())
                .Type(dto.getType())
                .build();
    }

    public static List<Cours> toCoursList(List<CoursDTO> list) {
        List<Cours> coursList = new ArrayList<>();
        for (CoursDTO dto : list) {
            coursList.add(toCours(dto));
        }
        return coursList;
    }

}
