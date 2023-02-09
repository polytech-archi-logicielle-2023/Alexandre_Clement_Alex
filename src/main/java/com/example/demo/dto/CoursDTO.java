package com.example.demo.dto;
import lombok.*;

@Data
@Builder
public class CoursDTO {
    private String Nom_du_cours;
    private String Enseignant;
    private String Type;
}