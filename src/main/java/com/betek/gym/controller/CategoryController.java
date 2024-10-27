package com.betek.gym.controller;

import com.betek.gym.model.Category;
import com.betek.gym.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    @PostMapping
    public ResponseEntity<Category> addCategory(@Valid @RequestBody Category category) {
        Category savedCategory = categoryService.addCategory(category);
        return ResponseEntity.ok(savedCategory);
    }
}
