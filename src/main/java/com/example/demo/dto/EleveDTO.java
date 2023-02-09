package com.example.demo.dto;
import lombok.*;

@Data
@Builder
public class EleveDTO {
    private String name;
    private String surname;
    private String followed_course;
}