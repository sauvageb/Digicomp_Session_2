package com.training.ged.controller.dto;

import com.training.ged.domain.model.Customer;
import com.training.ged.domain.model.DocumentType;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;
@Data
public class CreateDocumentForm {
    private String fileName;
    private MultipartFile fileUpload;
    private DocumentType type;
    private Customer customer;
}
