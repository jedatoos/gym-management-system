package com.betek.gym.controller;

import com.betek.gym.exceptionhandler.HandlerException;
import com.betek.gym.model.Apprentice;
import com.betek.gym.service.ApprenticeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/apprentices")
public class ApprenticeController {

    private final ApprenticeService apprenticeService;

    @Autowired
    public ApprenticeController(ApprenticeService apprenticeService) {
        this.apprenticeService = apprenticeService;
    }

    // Endpoint para registrar un aprendiz
    @PostMapping
    public ResponseEntity<Apprentice> registerApprentice(@RequestBody Apprentice apprentice) {
        Apprentice newApprentice = apprenticeService.registerApprentice(apprentice);
        return ResponseEntity.ok(newApprentice);
    }
    @GetMapping
    public List<Apprentice> getApprentice() {
        return apprenticeService.getApprentice();
    }

    // Endpoint para actualizar un aprendiz
    @PutMapping("/{id}")
    public ResponseEntity<Apprentice> updateApprentice(@PathVariable Long id, @RequestBody Apprentice apprenticeDetails) {
        try {
            Apprentice updatedApprentice = apprenticeService.updateApprentice(id, apprenticeDetails);
            return ResponseEntity.ok(updatedApprentice);
        } catch (HandlerException.ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Endpoint para obtener un aprendiz por ID
    @GetMapping("/{id}")
    public ResponseEntity<Apprentice> getApprenticeById(@PathVariable Long id) {
        try {
            Apprentice apprentice = apprenticeService.getApprenticeById(id);
            return ResponseEntity.ok(apprentice);
        } catch (HandlerException.ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Endpoint para asociar un entrenador a un aprendiz
    @PutMapping("/{apprenticeId}/trainers/{trainerId}")
    public ResponseEntity<String> associateTrainer(@PathVariable Long apprenticeId, @PathVariable Long trainerId) {
        try {
            apprenticeService.associateTrainer(apprenticeId, trainerId);
            return ResponseEntity.ok("Trainer associated successfully");
        } catch (HandlerException.ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}