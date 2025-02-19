package com.training.ged.domain.model;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class Customer {
    private UUID id;
    private String firstName;
    private String lastName;
}
