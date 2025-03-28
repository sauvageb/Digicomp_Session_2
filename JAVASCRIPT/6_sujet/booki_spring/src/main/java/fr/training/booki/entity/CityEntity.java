package fr.training.booki.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Table(name = "city")
@Entity
@Data
public class CityEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private String zipcode;
    @OneToMany(mappedBy = "city")
    private List<AccommodationEntity> accommodationEntities;
    @OneToMany(mappedBy = "city")
    private List<ActivityEntity> activities;
}
