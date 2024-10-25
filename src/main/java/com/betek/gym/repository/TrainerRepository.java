package com.betek.gym.repository;

import com.betek.gym.model.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TrainerRepository extends JpaRepository<Trainer, Long> {

    Optional<Trainer> findByTrainerId(Long trainerId);

    Optional<Trainer> findByEmail(String email);

    Optional<Trainer> findByPassword(String password);
}
