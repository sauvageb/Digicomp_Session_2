package com.training.demo.model;

import java.time.LocalDateTime;
import java.util.UUID;

public record Operation(UUID id, LocalDateTime createdAt, double amount, OperationDirection direction) {
}
