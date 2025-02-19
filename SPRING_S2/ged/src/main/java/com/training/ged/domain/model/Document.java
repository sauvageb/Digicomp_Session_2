package com.training.ged.domain.model;

import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
public class Document {
    private UUID id;
    private Customer customer;
    private DocumentStatus status;
    private String fileName;
    private DocumentType type;
    private Instant expiryDate;
    private LocalDateTime createdDate;
    private byte[] file;
}
