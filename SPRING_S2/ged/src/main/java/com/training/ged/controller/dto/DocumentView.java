package com.training.ged.controller.dto;

import com.training.ged.domain.model.Customer;
import com.training.ged.domain.model.DocumentStatus;
import com.training.ged.domain.model.DocumentType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@AllArgsConstructor
@Data
public class DocumentView {
    private UUID id;
    private String fileName;
    private DocumentType type;
    private Customer customer;
    private DocumentStatus status;
    private LocalDateTime createdDate;
}
