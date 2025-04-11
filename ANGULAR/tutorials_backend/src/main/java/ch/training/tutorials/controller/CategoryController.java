package ch.training.tutorials.controller;

import ch.training.tutorials.controller.dto.Category;
import ch.training.tutorials.controller.dto.CreateCategory;
import ch.training.tutorials.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/categories")
@CrossOrigin
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<Category>> fetchAll() {
        List<Category> categories = categoryService.fetchAll();
        return ResponseEntity.status(HttpStatus.OK).body(categories);
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody CreateCategory createCategory) {
        Category created = categoryService.createCategory(createCategory);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}