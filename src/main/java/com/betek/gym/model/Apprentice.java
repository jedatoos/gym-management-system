package com.betek.gym.model;


import com.betek.gym.util.MessageConstants;
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

    @NotBlank(message = MessageConstants.NAME_NOT_BLANK)
    @Column(name = "name", nullable = false)
    private String name;

    @Email(message = MessageConstants.EMAIL_VALID)
    @NotBlank(message = MessageConstants.EMAIL_NOT_BLANK)
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @NotBlank(message = MessageConstants.PASSWORD_NOT_BLANK)
    @Size(min = MessageConstants.PASSWORD_MIN_LENGTH, message = MessageConstants.PASSWORD_MIN_SIZE)
    @Column(name = "password", nullable = false)
    private String password;

    @NotBlank(message = MessageConstants.BIRTHDATE_NOT_BLANK)
    @Column(name = "birthdate")
    private String birthdate;

    @NotBlank(message = MessageConstants.GENDER_NOT_BLANK)
    @Column(name = "gender")
    private String gender;

    @NotBlank(message = MessageConstants.TRAINING_GOAL_NOT_BLANK)
    @Column(name = "training_goal")
    private String trainingGoal;

    @NotBlank(message = MessageConstants.FITNESS_LEVEL_NOT_BLANK)
    @Column(name = "fitness_level")
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
