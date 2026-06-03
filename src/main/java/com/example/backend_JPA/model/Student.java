package com.example.backend_JPA.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)   //This works only with the integer, long (not with string)
    private int rollNo;
    @NotBlank(message="name cannot be blank")
    private String name;

    private String tech;
    private String gender;
    private String email;
    private String password;
}
