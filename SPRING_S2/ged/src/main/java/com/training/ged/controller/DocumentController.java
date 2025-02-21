package com.training.ged.controller;

import com.training.ged.domain.model.Document;
import com.training.ged.controller.dto.CreateDocumentForm;
import com.training.ged.controller.dto.DocumentView;
import com.training.ged.domain.service.DocumentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/documents")
@RequiredArgsConstructor
public class DocumentController {

    private final DocumentService documentService;

    @GetMapping("/sync")
    public RedirectView synchronizeDocuments(){
        // Appel HTTP vers l'url de l'API du déclenchement batch
        documentService.synchronize();
        return new RedirectView("/documents");
    }

    @GetMapping
    public String displayDocuments(Model model) {

        List<Document> documentList = documentService.findDocuments();

        model.addAttribute("documents", documentList
                .stream()
                .map(x -> DocumentView
                        .builder()
                        .id(x.getId())
                        .fileName(x.getFileName())
                        .type(x.getType())
                        .customer(x.getCustomer())
                        .status(x.getStatus())
                        .createdDate(x.getCreatedDate())
                        .build())
                .toList());

        return "documents/document_list.html";
    }

    @GetMapping("/upload")
    public String displayUploadForm(Model model){
        model.addAttribute("newDocument", new CreateDocumentForm());
        return "documents/document_upload.html";
    }

    @PostMapping("/upload")
    public RedirectView upload(CreateDocumentForm form) throws IOException {
        documentService.upload(form);
        return new RedirectView("/documents");
    }


}
