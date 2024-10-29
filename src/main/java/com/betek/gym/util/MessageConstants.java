package com.betek.gym.util;

public class MessageConstants {

    // Valores de límite Generales
    public static final int NAME_MAX_LENGTH = 50;
    public static final int EMAIL_MAX_LENGTH = 50;
    public static final int PASSWORD_MIN_LENGTH = 6;
    public static final int SPECIALTY_MAX_LENGTH = 30;
    public static final int EXPERIENCE_MIN_YEARS = 0;
    public static final int CERTIFICATIONS_MAX_LENGTH = 100;

    // Trainers
    // Mensajes
    public static final String NAME_NOT_BLANK = "Name cannot be empty";
    public static final String NAME_SIZE_LIMIT = "Name cannot exceed " + NAME_MAX_LENGTH + "characters";

    public static final String EMAIL_VALID = "Email must be valid";
    public static final String EMAIL_NOT_BLANK = "Email cannot be empty";

    public static final String PASSWORD_NOT_BLANK = "Password cannot be empty";
    public static final String PASSWORD_MIN_SIZE = "Password must be at least " + PASSWORD_MIN_LENGTH + "characters";

    public static final String SPECIALTY_NOT_BLANK = "Specialty cannot be empty";
    public static final String SPECIALTY_SIZE_LIMIT = "Specialty cannot exceed " + SPECIALTY_MAX_LENGTH + "characters";

    public static final String EXPERIENCE_POSITIVE = "Experience cannot have negative values";

    public static final String CERTIFICATIONS_SIZE_LIMIT = "Certifications cannot exceed " + CERTIFICATIONS_MAX_LENGTH + " characters";


  //Category
  // Valores de límite

    public static final int CATEGORY_NAME_MAX_LENGTH = 50;

    // Constantes específicas para la categoría
    public static final String CATEGORY_NAME_NOT_BLANK = "Category name cannot be empty";
    public static final String CATEGORY_NAME_SIZE_LIMIT = "Category name cannot exceed " + CATEGORY_NAME_MAX_LENGTH + " characters";

    // Aprentice

    // Constantes específicas para esta entidad
    public static final String BIRTHDATE_NOT_BLANK = "Birthdate cannot be empty";
    public static final String GENDER_NOT_BLANK = "Gender cannot be empty";
    public static final String TRAINING_GOAL_NOT_BLANK = "Training goal cannot be empty";
    public static final String FITNESS_LEVEL_NOT_BLANK = "Fitness level cannot be empty";



    public MessageConstants() {
    }
}
