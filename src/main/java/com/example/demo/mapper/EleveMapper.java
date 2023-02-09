package com.example.demo.mapper;
import com.example.demo.dto.EleveDTO;
import com.example.demo.model.Eleve;

import java.util.*;

public class EleveMapper {

    public static EleveDTO toEleveDTO(Eleve eleve) {
        return EleveDTO.builder()
                .name(eleve.getName())
                .surname(eleve.getSurname())
                .followed_course(eleve.getFollowed_course())
                .build();
    }

    public static List<EleveDTO> toEleveDTOList(List<Eleve> list) {
        List<EleveDTO> dtoList = new ArrayList<>();
        for (Eleve eleve : list) {
            dtoList.add(toEleveDTO(eleve));
        }
        return dtoList;
    }

    public static Eleve toEleve(EleveDTO dto) {
        return Eleve.builder()
                .name(dto.getName())
                .surname(dto.getSurname())
                .followed_course(dto.getFollowed_course())
                .build();
    }

    public static List<Eleve> toEleveList(List<EleveDTO> list) {
        List<Eleve> eleveList = new ArrayList<>();
        for (EleveDTO dto : list) {
            eleveList.add(toEleve(dto));
        }
        return eleveList;
    }

}
