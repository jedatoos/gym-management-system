package com.example.Gym.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "apprentices")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Apprentice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long apprenticeId;


    @NotBlank(message = "El nombre no puede estar vacío")
    @Column(name = "name", nullable = false) // Columna: name
    private String name;

    @Email(message = "El email debe ser válido")
    @NotBlank(message = "El email no puede estar vacío")
    @Column(name = "email", nullable = false, unique = true) // Columna: email
    private String email;

    @NotBlank(message = "La contraseña no puede estar vacía")
    @Size(min = 6, message = "La contraseña debe tener al menos 6 caracteres")
    @Column(name = "password", nullable = false) // Columna: password
    private String password;

    @Column(name = "birthdate") // Columna: birthdate
    private String birthdate;

    @Column(name = "gender") // Columna: gender
    private String gender;

    @Column(name = "training_goal") // Columna: training_goal
    private String trainingGoal;

    @Column(name = "fitness_level") // Columna: fitness_level
    private String fitnessLevel;


    @ManyToOne
    @JoinColumn(name = "trainer_id")
    private Trainer trainer;

    @OneToMany(mappedBy = "apprentice")
    private List<Activity> activities;

}
