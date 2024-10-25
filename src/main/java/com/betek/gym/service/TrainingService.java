package com.betek.gym.service;

import com.betek.gym.repository.ApprenticeRepository;
import com.betek.gym.repository.TrainerRepository;
import com.betek.gym.external.TrainingClient;
import com.betek.gym.external.dto.TrainingDTO;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class TrainingService {
    private final ApprenticeRepository apprenticeRepository;


    private final TrainingClient trainingClient; // Feign client to send activities to another microservice

    @Autowired
    public TrainingService(ApprenticeService apprenticeService, TrainerService trainerService, TrainingClient activityClient, ApprenticeRepository apprenticeRepository, TrainerRepository trainerRepository, TrainingClient trainingClient) {

        this.apprenticeRepository = apprenticeRepository;


        this.trainingClient = trainingClient;
    }

    // Método para verificar la existencia del aprendiz y del entrenador, y luego registrar la actividad
    public TrainingDTO saveTraining(TrainingDTO trainingDTO)  {



        return trainingClient.saveTraining(trainingDTO);
    }
}