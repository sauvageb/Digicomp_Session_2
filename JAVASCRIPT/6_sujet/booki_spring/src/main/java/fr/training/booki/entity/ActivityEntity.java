package fr.training.booki.entity;

import jakarta.persistence.*;
import lombok.Data;

@Table(name = "activity")
@Entity
@Data
public class ActivityEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String address;
    private double price;
    private String pictureUrl;
    @ManyToOne
    @JoinColumn(name = "city_fk")
    private CityEntity city;
}
