package fr.training.booki.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Accommodation {
    private Long id;
    private String title;
    private String description;
    private String address;
    private double price;
    private int rating;
    private int capacity;
    private String pictureUrl;
    private City city;
}
