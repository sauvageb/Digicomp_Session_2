package com.training.ged.repository.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "tb_customers")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CustomerEntity {
    @Id
    private UUID id;
    private String firstName;
    private String lastName;
}
