package ch.training.tutorials.service;

import ch.training.tutorials.controller.dto.Category;
import ch.training.tutorials.controller.dto.CreateCategory;
import ch.training.tutorials.repository.CategoryRepository;
import ch.training.tutorials.repository.entity.CategoryEntity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final ModelMapper modelMapper;

    private final CategoryRepository categoryRepository;

    public Category createCategory(CreateCategory createCategory) {
        CategoryEntity categoryToSave = modelMapper.map(createCategory, CategoryEntity.class);
        CategoryEntity categorySaved = categoryRepository.save(categoryToSave);
        return modelMapper.map(categorySaved, Category.class);
    }

    public List<Category> fetchAll() {
        List<CategoryEntity> categoryEntities = (List<CategoryEntity>) categoryRepository.findAll();
        return categoryEntities
                .stream()
                .map(x -> modelMapper.map(x, Category.class))
                .toList();
    }
}
