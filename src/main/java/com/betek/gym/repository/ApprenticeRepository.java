package com.betek.gym.repository;

import com.betek.gym.model.Apprentice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ApprenticeRepository extends JpaRepository<Apprentice, Long> {
    // Aquí puedes agregar métodos adicionales si es necesario
    Optional<Apprentice> findByApprenticeId(Long apprenticeId);
}