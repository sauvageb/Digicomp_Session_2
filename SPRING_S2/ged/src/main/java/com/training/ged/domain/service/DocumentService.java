package com.training.ged.domain.service;

import com.training.ged.controller.dto.CreateDocumentForm;
import com.training.ged.domain.model.Customer;
import com.training.ged.domain.model.Document;
import com.training.ged.domain.model.DocumentStatus;
import com.training.ged.repository.entity.CustomerEntity;
import com.training.ged.repository.entity.DocumentEntity;
import com.training.ged.repository.CustomerRepository;
import com.training.ged.repository.DocumentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class DocumentService {

    private final DocumentRepository documentRepository;
    private final CustomerRepository customerRepository;

    public void upload(CreateDocumentForm form) throws IOException {
        Optional<CustomerEntity> customerOpt = customerRepository
                .findById(form.getCustomer().getId());

        DocumentEntity.DocumentEntityBuilder docBuilder = DocumentEntity.builder()
                .id(UUID.randomUUID())
                .createdDate(LocalDateTime.now())
                .expiryDate(Instant.now())
                .status(DocumentStatus.CREATED)
                .type(form.getType())
                .fileName(form.getFileName())
                .file(form.getFileUpload().getBytes());

        if(customerOpt.isPresent()){
            docBuilder.customer(customerOpt.get());
        }

        DocumentEntity documentEntity = docBuilder.build();

        documentRepository.save(documentEntity);
    }

    public List<Document> findDocuments() {
        return documentRepository.findAll()
                .stream()
                .map(x-> Document
                        .builder()
                        .id(x.getId())
                        .createdDate(x.getCreatedDate())
                        .expiryDate(x.getExpiryDate())
                        .status(x.getStatus())
                        .customer(Customer.builder()
                                .lastName(x.getCustomer().getLastName())
                                .firstName(x.getCustomer().getFirstName())
                                .build())
                        .type(x.getType())
                        .file(x.getFile())
                        .fileName(x.getFileName())
                        .build())
                .toList();
    }
}
