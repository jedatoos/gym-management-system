package com.betek.gym.external.dto;

import com.betek.gym.util.MessageConstants;
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

    private Long apprenticeId;

    private String apprenticeUsername;

    private String trainerId;

    private String trainingName;

    private LocalDate trainingDate;

    private String trainingType;

    private String trainingDuration;
}