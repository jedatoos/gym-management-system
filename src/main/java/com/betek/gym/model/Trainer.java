package com.betek.gym.model;


import com.betek.gym.util.MessageConstants;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "trainers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Trainer {
    @Id
    @Column(name = "trainer_id") // Nombre de la columna en la base de datos
    private Long trainerId;
    @NotBlank(message = MessageConstants.NAME_NOT_BLANK)
    @Size(max = MessageConstants.NAME_MAX_LENGTH, message = MessageConstants.NAME_SIZE_LIMIT)
    @Column(name = "name", nullable = false, length = MessageConstants.NAME_MAX_LENGTH)
    private String name;

    @Email(message = MessageConstants.EMAIL_VALID)
    @NotBlank(message = MessageConstants.EMAIL_NOT_BLANK)
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @NotBlank(message = MessageConstants.PASSWORD_NOT_BLANK)
    @Size(min = MessageConstants.PASSWORD_MIN_LENGTH, message = MessageConstants.PASSWORD_MIN_SIZE)
    @Column(name = "password", nullable = false)
    private String password;

    @NotBlank(message = MessageConstants.SPECIALTY_NOT_BLANK)
    @Size(max = MessageConstants.SPECIALTY_MAX_LENGTH, message = MessageConstants.SPECIALTY_SIZE_LIMIT)
    @Column(name = "specialty", nullable = false, length = MessageConstants.SPECIALTY_MAX_LENGTH)
    private String specialty;

    @Min(value = MessageConstants.EXPERIENCE_MIN_YEARS, message = MessageConstants.EXPERIENCE_POSITIVE)
    @Column(name = "experience_years")
    private int experienceYears;

    @Size(max = MessageConstants.CERTIFICATIONS_MAX_LENGTH, message = MessageConstants.CERTIFICATIONS_SIZE_LIMIT)
    @Column(name = "certifications", length = MessageConstants.CERTIFICATIONS_MAX_LENGTH)
    private String certifications;

    @OneToMany(mappedBy = "trainer")
    @JsonIgnore //para no repetir impresion en postman ignora el ciclo
  //  @JsonBackReference //asociacion para no repetir impresion en postman
    private List<Apprentice> apprentices;

}