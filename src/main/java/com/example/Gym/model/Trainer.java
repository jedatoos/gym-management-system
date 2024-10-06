package com.example.Gym.model;


import jakarta.persistence.*;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "trainers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Trainer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "trainer_id") // Nombre de la columna en la base de datos
    private Long trainerId;

    @NotBlank(message = "El nombre no puede estar vacío")
    @Size(max = 50, message = "El nombre no puede tener más de 50 caracteres")
    @Column(name = "name", nullable = false, length = 50) // Nombre de la columna
    private String name;

    @Email(message = "El correo electrónico debe ser válido")
    @NotBlank(message = "El correo electrónico no puede estar vacío")
    @Column(name = "email", nullable = false, unique = true) // Nombre de la columna
    private String email;

    @NotBlank(message = "La contraseña no puede estar vacía")
    @Size(min = 6, message = "La contraseña debe tener al menos 6 caracteres")
    @Column(name = "password", nullable = false) // Nombre de la columna
    private String password;

    @NotBlank(message = "La especialidad no puede estar vacía")
    @Size(max = 30, message = "La especialidad no puede tener más de 30 caracteres")
    @Column(name = "specialty", nullable = false, length = 30) // Nombre de la columna
    private String specialty;

    @Min(value = 0, message = "La experiencia no puede tener valores negativos ")
    @Column(name = "experience_years") // Nombre de la columna
    private int experienceYears;

    @Size(max = 100, message = "Las certificaciones no pueden tener más de 100 caracteres")
    @Column(name = "certifications", length = 100) // Nombre de la columna
    private String certifications;

    @OneToMany(mappedBy = "trainer")
    private List<Apprentice> apprentices;

}