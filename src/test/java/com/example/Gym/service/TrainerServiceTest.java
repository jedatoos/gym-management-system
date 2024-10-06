package com.example.Gym.service;

import com.example.Gym.model.Trainer;
import com.example.Gym.repository.TrainerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TrainerServiceTest {
    @Mock
    private TrainerRepository trainerRepository;
    @InjectMocks
    private TrainerService trainerService;

    @Test
    void testgetTrainers() {
        List<Trainer> mockTrainers = List.of(
                new Trainer(
                        1L, // trainerId
                        "John Doe", // name
                        "john@example.com", // email
                        "password123", // password
                        "Fitness", // specialty
                        5, // experienceYears
                        "Cert1", // certifications
                        new ArrayList<>() // apprentices
                ),
                new Trainer(
                        2L, // trainerId
                        "Jane Smith", // name
                        "jane@example.com", // email
                        "password456", // password
                        "Yoga", // specialty
                        3, // experienceYears
                        "Cert2", // certifications
                        new ArrayList<>() // apprentices
                )
        );

        when(trainerRepository.findAll()).thenReturn(mockTrainers);

        List<Trainer> trainers = trainerService.getTrainers();

        assertNotNull(trainers);
        assertEquals(2, trainers.size());
        verify(trainerRepository, times(1)).findAll();
    }

    @Test
    void addTrainer() {
    }

    @Test
    void updateTrainer() {
    }
}