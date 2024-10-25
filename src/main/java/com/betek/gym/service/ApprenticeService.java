package com.betek.gym.service;

import com.betek.gym.exceptionhandler.HandlerException;
import com.betek.gym.repository.ApprenticeRepository;
import com.betek.gym.model.Apprentice;
import com.betek.gym.model.Trainer;
import com.betek.gym.repository.TrainerRepository;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApprenticeService {


    private final ApprenticeRepository apprenticeRepository;

    private final TrainerRepository trainerRepository;

    @Autowired
    public ApprenticeService(ApprenticeRepository apprenticeRepository, TrainerRepository trainerRepository) {
        this.apprenticeRepository = apprenticeRepository;
        this.trainerRepository = trainerRepository;
    }


    // Método para registrar un aprendiz
    public Apprentice registerApprentice(Apprentice apprentice) {
        if (apprenticeRepository.findByApprenticeId(apprentice.getApprenticeId()).isPresent()) {
            throw new ValidationException("The ApprenticeId is already registered.");
        }
        return apprenticeRepository.save(apprentice);
    }

    //listar aprendices
    public List<Apprentice> getApprentice() {
        return apprenticeRepository.findAll();
    }

    // Método para actualizar un aprendiz
    public Apprentice updateApprentice(Long apprenticeId, Apprentice apprenticeDetails) throws HandlerException.ResourceNotFoundException {
        Optional<Apprentice> optionalApprentice = apprenticeRepository.findByApprenticeId(apprenticeId);
        if (optionalApprentice.isPresent()) {


            Apprentice updatedApprentice = optionalApprentice.get();

            updatedApprentice.setName(apprenticeDetails.getName());
            updatedApprentice.setEmail(apprenticeDetails.getEmail());
            updatedApprentice.setPassword(apprenticeDetails.getPassword());
            updatedApprentice.setBirthdate(apprenticeDetails.getBirthdate());
            updatedApprentice.setGender(apprenticeDetails.getGender());
            updatedApprentice.setTrainingGoal(apprenticeDetails.getTrainingGoal());
            updatedApprentice.setFitnessLevel(apprenticeDetails.getFitnessLevel());
            return apprenticeRepository.save(updatedApprentice);
        } else {
            throw new HandlerException.ResourceNotFoundException("Apprentice not found with id " + apprenticeId);
        }
    }

    // Método para obtener un aprendiz por ID
    public Apprentice getApprenticeById(Long id) throws HandlerException.ResourceNotFoundException {
        return apprenticeRepository.findById(id)
                .orElseThrow(() -> new HandlerException.ResourceNotFoundException("Apprentice not found with id " + id));
    }

    // Método para asociar un entrenador a un aprendiz
    public void associateTrainer(Long apprenticeId, Long trainerId) throws HandlerException.ResourceNotFoundException {
        Optional<Apprentice> optionalApprentice = apprenticeRepository.findById(apprenticeId);
        Optional<Trainer> optionalTrainer = trainerRepository.findById(trainerId);

        if (optionalApprentice.isPresent() && optionalTrainer.isPresent()) {
            Apprentice apprentice = optionalApprentice.get();
            Trainer trainer = optionalTrainer.get();
            apprentice.setTrainer(trainer); // Asocia el entrenador al aprendiz
            apprenticeRepository.save(apprentice); // Guarda el aprendiz actualizado
        } else {
            throw new HandlerException.ResourceNotFoundException("Apprentice or Trainer not found");
        }
    }
}