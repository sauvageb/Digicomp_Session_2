package com.training.ged.repository.entity;

import com.training.ged.domain.model.DocumentStatus;
import com.training.ged.domain.model.DocumentType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "tb_documents")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class DocumentEntity {

    @Id
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private CustomerEntity customer;

    @Enumerated(EnumType.STRING)
    private DocumentStatus status;

    @Enumerated(EnumType.STRING)
    private DocumentType type;

    private Instant expiryDate;
    private LocalDateTime createdDate;

    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] file;
    private String fileName;
}
