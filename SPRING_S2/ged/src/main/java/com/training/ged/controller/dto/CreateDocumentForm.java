package com.training.ged.controller.dto;

import com.training.ged.domain.model.Customer;
import com.training.ged.domain.model.DocumentType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateDocumentForm {
    private String fileName;
    private MultipartFile fileUpload;
    private DocumentType type;
    private Customer customer;
}
