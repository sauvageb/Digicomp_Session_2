package com.training.ged.domain.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum DocumentStatus {
    CREATED("Créé"),
    RECEIVED("Reçu"),
    SIGNED("Signé"),
    VALIDATED("Validé"),
    EXPIRED("Expiré");

    private final String name;
}
