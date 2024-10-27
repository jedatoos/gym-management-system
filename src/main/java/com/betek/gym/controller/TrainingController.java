package com.betek.gym.controller;

import com.betek.gym.external.dto.TrainingDTO;
import com.betek.gym.external.TrainingClient;

import com.betek.gym.service.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/activity")
public class TrainingController {
    private final TrainingService trainingService;

    @Autowired
    public TrainingController(TrainingService trainingService) {
        this.trainingService = trainingService;
    }

    @PostMapping("/trainings")
    public ResponseEntity<TrainingDTO> createTraining(@RequestBody TrainingDTO trainingDTO) {
        // Llamar a `TrainingService` para guardar el entrenamiento
        TrainingDTO savedTraining = trainingService.saveTraining(trainingDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedTraining);
    }

    @GetMapping("/trainings/{apprenticeId}")
    public ResponseEntity<TrainingDTO> getTrainingByApprenticeId(@PathVariable String apprenticeId) {
        // Llamar a `TrainingService` para obtener el entrenamiento del aprendiz
        TrainingDTO trainingDTO = trainingService.getTrainingByApprenticeId(apprenticeId);
        if (trainingDTO != null) {
            return ResponseEntity.ok(trainingDTO);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}