package com.example.Gym.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "training_activities")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "activity_id")
    private Long activityId;

    @Column(nullable = false)
    @NotNull(message = "EL tipode entrenamiento no puede estar vacío")
    private String trainingType;

    @Column(name = "training_date", nullable = false)
    @Temporal(TemporalType.DATE)
    @NotNull(message = "La fecha de entrenamiento no puede estar vacía")
    private Date trainingDate;

    @Column(name = "duration_minutes", nullable = false)
    @Min(value = 1, message = "La duración debe ser al menos de 1 minuto")
    @Max(value = 300, message = "La duración no puede exceder los 300 minutos")
    private int durationMinutes;


    @ManyToOne
    @JoinColumn(name = "apprentice_id")
    private Apprentice apprentice;

    @ManyToOne
    @JoinColumn(name = "trainer_id")
    private Trainer trainer;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;




}