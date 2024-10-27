package com.betek.gym.service;

import com.betek.gym.exceptionhandler.ApprenticeNotFoundException;
import com.betek.gym.exceptionhandler.TrainerNotFoundException;
import com.betek.gym.repository.ApprenticeRepository;
import com.betek.gym.repository.TrainerRepository;
import com.betek.gym.external.TrainingClient;
import com.betek.gym.external.dto.TrainingDTO;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class TrainingService {

    private final TrainerRepository trainerRepository;
    private final ApprenticeRepository apprenticeRepository;
    private final TrainingClient trainingClient; // Feign client to interact with another microservice

    @Autowired
    public TrainingService(TrainerRepository trainerRepository, ApprenticeRepository apprenticeRepository, TrainingClient trainingClient) {
        this.trainerRepository = trainerRepository;
        this.apprenticeRepository = apprenticeRepository;
        this.trainingClient = trainingClient;
    }

    // Lógica para guardar el entrenamiento usando el `TrainingClient`
    public TrainingDTO saveTraining(TrainingDTO trainingDTO) {

        // Verificar si el `apprenticeId` existe en la base de datos
        if (!apprenticeRepository.existsById(trainingDTO.getApprenticeId())) {
            throw new ApprenticeNotFoundException("El aprendiz con ID " + trainingDTO.getApprenticeId() + " no existe.");
        }


        // Verificar si el `trainerId` existe en la base de datos
        if (!trainerRepository.existsById(Long.valueOf(trainingDTO.getTrainerId()))) {
            throw new TrainerNotFoundException("El entrenador con ID " + trainingDTO.getTrainerId() + " no existe.");
        }



        // Si ambos existen, procede a guardar el entrenamiento en el otro microservicio
        return trainingClient.saveTraining(trainingDTO);
    }

    // Lógica para obtener el entrenamiento de un aprendiz por ID
    public TrainingDTO getTrainingByApprenticeId(String apprenticeId) {
        // Aquí puedes incluir lógica adicional antes de llamar a `trainingClient`
        return trainingClient.getTrainingByApprenticeId(apprenticeId);
    }
}