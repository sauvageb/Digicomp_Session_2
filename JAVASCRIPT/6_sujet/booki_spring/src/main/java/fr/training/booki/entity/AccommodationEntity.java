package fr.training.booki.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "accommodation")
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccommodationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String address;
    private double price;
    private int rating;
    private int capacity;
    private String pictureUrl;
    @ManyToOne
    @JoinColumn(name = "city_fk")
    private CityEntity city;
}
