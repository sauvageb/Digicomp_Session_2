package com.training.ged.batch;

import com.training.ged.domain.model.Customer;
import com.training.ged.domain.model.Document;
import com.training.ged.domain.model.DocumentStatus;
import com.training.ged.domain.model.DocumentType;
import com.training.ged.domain.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
@Log
public class DocumentCsvProcessor implements ItemProcessor<DocumentCSV, Document> {

    private final CustomerService customerService;

    @Override
    public Document process(DocumentCSV item) throws Exception {
        log.info("batch processing");
        UUID customerId = UUID.fromString(item.getCustomerId());
        Optional<Customer> customerOptional = customerService.findCustomer(customerId);

        return Document
                .builder()
                .id(UUID.randomUUID())
                .createdDate(LocalDateTime.now())
                .expiryDate(Instant.parse(item.getExpiryDate()))
                .fileName(item.getFileName())
                .type(DocumentType.valueOf(item.getType()))
                .status(DocumentStatus.valueOf(item.getStatus()))
                .customer(customerOptional.orElse(null))
                .build();
    }
}
