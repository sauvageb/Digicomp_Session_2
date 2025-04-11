package ch.training.tutorials.repository.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "categories")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
}
