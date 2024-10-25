package com.betek.gym.external.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrainingDTO {
 
    @NotBlank(message = "Apprentice ID is mandatory")
    private Long apprenticeId;

    @NotBlank(message = "Apprentice Username is mandatory")
    private String apprenticeUsername;

    @NotBlank(message = "Trainer ID is mandatory")
    private String trainerId;

    @NotBlank(message = "Training Name is mandatory")
    private String trainingName;

    @NotNull(message = "Training Date is mandatory")
    private LocalDate trainingDate; // Se puede cambiar a LocalDate si se prefiere

    @NotBlank(message = "Training Type is mandatory")
    private String trainingType;

    @NotNull(message = "Duration is mandatory")
    private String trainingDuration;
}