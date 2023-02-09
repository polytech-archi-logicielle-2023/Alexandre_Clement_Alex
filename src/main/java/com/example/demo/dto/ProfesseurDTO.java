package com.example.demo.dto;
import lombok.*;

@Data
@Builder
public class ProfesseurDTO {
    private String name;
    private String surname;
    private String course;
}