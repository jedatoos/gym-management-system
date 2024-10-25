package com.betek.gym.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "apprentices")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Apprentice {
    @Id

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

    @NotBlank(message = "La fecha de nacimiento  no puede estar vacía")
    @Column(name = "birthdate") // Columna: birthdate
    private String birthdate;

    @NotBlank(message = "El género  no puede estar vacía")
    @Column(name = "gender") // Columna: gender
    private String gender;

    @NotBlank(message = "el objetivo del entrenamiento no puede estar vacío")
    @Column(name = "training_goal") // Columna: training_goal
    private String trainingGoal;

    @NotBlank(message = "el nivel de condicion fisica  no puede estar vacía")
    @Column(name = "fitness_level") // Columna: fitness_level
    private String fitnessLevel;


    @ManyToOne
 //   @JsonManagedReference  //asociacion para no repetir impresion en postman
    @JoinColumn(name = "trainer_id")
    private Trainer trainer;



    // Método para obtener el ID del entrenador asociado
    public Long getAssociatedTrainerId() {
        return trainer != null ? trainer.getTrainerId() : null; // Retorna el ID del entrenador si existe
    }

    // Método para establecer el entrenador asociado
    public void setAssociatedTrainer(Trainer trainer) {
        this.trainer = trainer; // Establece el entrenador asociado
    }

}
