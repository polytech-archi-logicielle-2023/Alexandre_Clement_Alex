package com.example.demo.dto;
import lombok.*;

@Data
@Builder
public class UserDTO {
    private String name;
    private String email;
}