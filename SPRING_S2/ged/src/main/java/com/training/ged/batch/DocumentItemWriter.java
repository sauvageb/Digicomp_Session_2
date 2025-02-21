package com.training.ged.batch;

import com.training.ged.domain.model.Document;
import com.training.ged.repository.DocumentRepository;
import com.training.ged.repository.entity.CustomerEntity;
import com.training.ged.repository.entity.DocumentEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@RequiredArgsConstructor
public class DocumentItemWriter implements ItemWriter<Document> {

    private final DocumentRepository documentRepository;

    @Override
    public void write(Chunk<? extends Document> chunk) {
        List<? extends Document> documentList = chunk.getItems();



        List<DocumentEntity> entityList = documentList
                .stream()
                .map(d -> DocumentEntity
                        .builder()
                        .id(d.getId())
                        .fileName(d.getFileName())
                        .createdDate(d.getCreatedDate())
                        .status(d.getStatus())
                        .type(d.getType())
                        .expiryDate(d.getExpiryDate())
                        .customer(CustomerEntity.builder()
                                .id(d.getCustomer().getId())
                                .firstName(d.getCustomer().getFirstName())
                                .lastName(d.getCustomer().getLastName())
                                .build())
                        .build()
                ).toList();

        documentRepository.saveAll(entityList);
    }
}
