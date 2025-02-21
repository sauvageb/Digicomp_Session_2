package com.training.ged.test.domain.service;

import com.training.ged.controller.dto.CreateDocumentForm;
import com.training.ged.domain.model.Customer;
import com.training.ged.domain.model.DocumentStatus;
import com.training.ged.domain.service.DocumentService;
import com.training.ged.repository.CustomerRepository;
import com.training.ged.repository.DocumentRepository;
import com.training.ged.repository.entity.CustomerEntity;
import com.training.ged.repository.entity.DocumentEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockMultipartFile;

import java.io.IOException;
import java.util.Optional;
import java.util.UUID;

@ExtendWith(MockitoExtension.class)
// @ExtendWith(MockitoExtension.class) : Active l'utilisation de la dépendance Mockito dans ce Test
// Permet donc d'utiliser @InjectMocks, @Mock et Mockito.verify
class DocumentServiceTest {

    @Mock // Bouchon de DocumentRepository
    private DocumentRepository documentRepository;
    @Mock // Bouchon de CustomerRepository
    private CustomerRepository customerRepository;
    @InjectMocks // La classe à tester, dans laquelle on injecte les bouchons
    private DocumentService documentService;

    @Test
    public void myTest() throws IOException {
        // Given
        UUID customerId = UUID.randomUUID();
        Customer customer = Customer.builder().id(customerId).build();

        CreateDocumentForm form = CreateDocumentForm
                .builder()
                .fileUpload(new MockMultipartFile("test.pdf", new byte[]{}))
                .customer(customer)
                .build();

        Mockito.when(customerRepository.findById(customerId)).thenReturn(Optional.of(new CustomerEntity()));

        // When
        documentService.upload(form);

        // Then
        Mockito.verify(documentRepository, Mockito.times(1))
                .save(Mockito.any(DocumentEntity.class));

        ArgumentCaptor<DocumentEntity> captor = ArgumentCaptor.forClass(DocumentEntity.class);
        Mockito.verify(documentRepository).save(captor.capture());
        DocumentEntity documentEntity = captor.getValue();
        Assertions.assertEquals(documentEntity.getStatus(), DocumentStatus.CREATED);
    }

}