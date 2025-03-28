package fr.training.booki.dto;

import lombok.Builder;
import lombok.Data;

@Data
public class City {
    private Long id;
    private String name;
    private String zipcode;
}
