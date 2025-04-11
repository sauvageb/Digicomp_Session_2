package ch.training.tutorials.repository;

import ch.training.tutorials.repository.entity.CategoryEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface CategoryRepository extends CrudRepository<CategoryEntity, UUID> {
}
