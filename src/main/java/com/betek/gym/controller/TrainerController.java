package com.betek.gym.controller;

import com.betek.gym.model.Trainer;
import com.betek.gym.service.TrainerService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("/trainers")
public class TrainerController {


    private final TrainerService trainerService;

    public TrainerController(TrainerService trainerService) {
        this.trainerService = trainerService;
    }

    @GetMapping
    public List<Trainer> getTrainers() {
        return trainerService.getTrainers();
    }

    @PostMapping
    public ResponseEntity<Trainer> addTrainer(@Valid @RequestBody Trainer trainer) {
        return ResponseEntity.ok(trainerService.addTrainer(trainer));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Trainer> updateTrainer(@PathVariable Long id, @RequestBody Trainer trainer) {
        return ResponseEntity.ok(trainerService.updateTrainer(id, trainer));
    }
}