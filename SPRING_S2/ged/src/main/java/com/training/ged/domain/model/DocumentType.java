package com.training.ged.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum DocumentType {
    PASSPORT("Passeport"),
    ACCOUNT_OPENING("Ouverture de compte");

    private final String name;
}
