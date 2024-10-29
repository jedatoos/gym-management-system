package com.betek.gym.service;

import com.betek.gym.model.Trainer;
import com.betek.gym.repository.TrainerRepository;
import jakarta.validation.ValidationException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TrainerServiceTest {
    @Mock
    private TrainerRepository trainerRepository;
    @InjectMocks
    private TrainerService trainerService;

    @Test
    @DisplayName("Debería listar todos los entrenadores correctamente")
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
    @DisplayName("Debería agregar un entrenador si el email y la contraseña no están registrados")
    public void shouldAddTrainerIfEmailAndPasswordNotRegistered() {
        // Datos simulados
        Trainer newTrainer = new Trainer(null, "John", "john@example.com", "password123", "Fitness", 5, "Certified Trainer", null);

        // Simulación de repositorio
        when(trainerRepository.findByEmail(newTrainer.getEmail())).thenReturn(Optional.empty());
        when(trainerRepository.findByPassword(newTrainer.getPassword())).thenReturn(Optional.empty());
        when(trainerRepository.save(newTrainer)).thenReturn(new Trainer(1L, "John", "john@example.com", "password123", "Fitness", 5, "Certified Trainer", null));

        // Llamada al método
        Trainer savedTrainer = trainerService.addTrainer(newTrainer);

        // Verificaciones
        assertNotNull(savedTrainer);
        assertEquals(1L, savedTrainer.getTrainerId());
        verify(trainerRepository, times(1)).save(newTrainer);
    }
    @Test
    @DisplayName("No debería agregar un entrenador si el email está registrado")
    public void shouldThrowExceptionIfEmailRegistered() {
        // Datos simulados
        Trainer newTrainer = new Trainer(null, "John", "john@example.com", "password123", "Fitness", 5, "Certified Trainer", null);

        // Simulación de repositorio
        when(trainerRepository.findByEmail(newTrainer.getEmail())).thenReturn(Optional.of(newTrainer));

        // Verificación de excepción
        assertThrows(ValidationException.class, () -> trainerService.addTrainer(newTrainer));
        verify(trainerRepository, never()).save(any());
    }
    @Test
    @DisplayName("No debería agregar un entrenador si el password está registrado")
    public void shouldThrowExceptionIfPasswordRegistered() {
        // Datos simulados
        Trainer newTrainer = new Trainer(null, "John", "john@example.com", "password123", "Fitness", 5, "Certified Trainer", null);

        // Simulación de repositorio
        when(trainerRepository.findByPassword(newTrainer.getPassword())).thenReturn(Optional.of(newTrainer));

        // Verificación de excepción
        assertThrows(ValidationException.class, () -> trainerService.addTrainer(newTrainer));
        verify(trainerRepository, never()).save(any());
    }

    @Test
    @DisplayName("Debería actualizar un entrenador existente")
    public void shouldUpdateExistingTrainer() {
        // Datos simulados
        Trainer existingTrainer = new Trainer(1L, "John", "john@example.com", "password123", "Fitness", 5, "Certified Trainer", null);
        Trainer updatedTrainer = new Trainer(1L, "John Doe", "john.doe@example.com", "newpassword123", "Fitness", 6, "Certified Advanced Trainer", null);

        // Simulación de repositorio
        when(trainerRepository.findById(1L)).thenReturn(Optional.of(existingTrainer));
        when(trainerRepository.save(existingTrainer)).thenReturn(updatedTrainer);

        // Llamada al método
        Trainer result = trainerService.updateTrainer(1L, updatedTrainer);

        // Verificaciones
        assertNotNull(result);
        assertEquals("John Doe", result.getName());
        assertEquals("john.doe@example.com", result.getEmail());
        verify(trainerRepository, times(1)).findById(1L);
        verify(trainerRepository, times(1)).save(existingTrainer);
    }
}