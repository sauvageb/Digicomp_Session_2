package ch.training.tutorials.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Builder
@NoArgsConstructor
@Data
@AllArgsConstructor
public class Category {
    private UUID id;
    private String name;
}
