package com.betek.gym.model;

import com.betek.gym.util.MessageConstants;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "training_categories")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Long categoryId;

    @NotBlank(message = MessageConstants.CATEGORY_NAME_NOT_BLANK)
    @Size(max = MessageConstants.CATEGORY_NAME_MAX_LENGTH, message = MessageConstants.CATEGORY_NAME_SIZE_LIMIT)
    @Column(name = "category_name")
    private String categoryName;




}
