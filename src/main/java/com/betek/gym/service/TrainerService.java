package com.betek.gym.service;

import com.betek.gym.repository.TrainerRepository;
import com.betek.gym.model.Trainer;
import jakarta.validation.ValidationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainerService {


    private final TrainerRepository trainerRepository;

    public TrainerService(TrainerRepository trainerRepository) {
        this.trainerRepository = trainerRepository;
    }

    public List<Trainer> getTrainers() {
        return trainerRepository.findAll();
    }

    public Trainer addTrainer(Trainer trainer) {
        if (trainerRepository.findByTrainerId(trainer.getTrainerId()).isPresent()) {
            throw new ValidationException("The TrainerId is already registered.");
        }
        if (trainerRepository.findByEmail(trainer.getEmail()).isPresent()) {
            throw new ValidationException("The email is already registered.");
        }
        if (trainerRepository.findByPassword(trainer.getPassword()).isPresent()) {
            throw new ValidationException("The password is already registered.");
        }
        return trainerRepository.save(trainer);
    }

    public Trainer updateTrainer(Long id, Trainer updatedTrainer) {
        Trainer existingTrainer = trainerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Trainer not found"));

        // Update existing trainer's attributes
        existingTrainer.setName(updatedTrainer.getName());
        existingTrainer.setEmail(updatedTrainer.getEmail());
        existingTrainer.setPassword(updatedTrainer.getPassword());
        existingTrainer.setSpecialty(updatedTrainer.getSpecialty());
        existingTrainer.setExperienceYears(updatedTrainer.getExperienceYears());
        existingTrainer.setCertifications(updatedTrainer.getCertifications());

        return trainerRepository.save(existingTrainer);
    }
    // buscar entrenador por id
    public Trainer getTrainerById(Long id) {
        return trainerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Trainer not found with id " + id));
    }
}
