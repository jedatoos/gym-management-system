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

    //llamar este metodo desde el servivio
    private final TrainingClient trainingClient;

    @Autowired
    public TrainingController(TrainingClient trainingClient) {
        this.trainingClient = trainingClient;
    }
    // por lo tanto las logicas de aedentro de estos metodos van tambien en el servicio
    @PostMapping("/trainings")
    public ResponseEntity<TrainingDTO> createTraining(@RequestBody TrainingDTO trainingDTO) {
        // Llamar a Microservicio 2 para guardar el entrenamiento
        TrainingDTO savedTraining = trainingClient.saveTraining(trainingDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedTraining);
    }

    // Método para obtener el entrenamiento de un aprendiz
    @GetMapping("/trainings/{apprenticeId}")
    public ResponseEntity<TrainingDTO> getTrainingByApprenticeId(@PathVariable String apprenticeId) {
        TrainingDTO trainingDTO = trainingClient.getTrainingByApprenticeId(apprenticeId);
        if (trainingDTO != null) {
            return ResponseEntity.ok(trainingDTO);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // Si no se encuentra
        }
    }



}