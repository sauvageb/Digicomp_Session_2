package com.training.ged.test.controller;

import com.training.ged.controller.dto.CreateDocumentForm;
import com.training.ged.controller.dto.DocumentView;
import com.training.ged.domain.model.Customer;
import com.training.ged.domain.model.Document;
import com.training.ged.domain.service.DocumentService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

@SpringBootTest // Chargement du context Spring Boot pour les tests d'integration
@AutoConfigureMockMvc // Autoconfigure Le MockMVC pour simuler les requêtes HTTP
class DocumentControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockitoBean // Permet de Bouchonner une classe dans le cadre des tests d'integration
    private DocumentService documentService;

    @Test
    @DisplayName("Affichage de la page contenant la liste des documents")
    public void testDisplayDocuments() throws Exception {
        // Given
        Customer c1 = Customer.builder().firstName("Boris").lastName("Sauvage").build();
        Document d1 = Document.builder().customer(c1).build();
        List<Document> documentList = List.of(d1, d1);
        Mockito.when(documentService.findDocuments()).thenReturn(documentList);
        List<DocumentView> documentViewList = documentList.stream()
                .map(d -> DocumentView.builder().customer(c1).build()).toList();
        // When
        var result = mockMvc.perform(MockMvcRequestBuilders.get("/documents"));

        // Then
        result.andExpect(MockMvcResultMatchers.status().isOk());
        result.andExpect(MockMvcResultMatchers.model().attributeExists("documents"));
        result.andExpect(MockMvcResultMatchers.model().attribute("documents", documentViewList));
        result.andExpect(MockMvcResultMatchers.view().name("documents/document_list.html"));
    }


    @Test
    void testDisplayUploadForm() throws Exception {
        // When
        var result = mockMvc.perform(MockMvcRequestBuilders.get("/documents/upload"));

        // Then
        result.andExpect(MockMvcResultMatchers.status().isOk());
        result.andExpect(MockMvcResultMatchers.model().attributeExists("newDocument"));
        result.andExpect(MockMvcResultMatchers.model().attribute("newDocument",  new CreateDocumentForm()));
        result.andExpect(MockMvcResultMatchers.view().name("documents/document_upload.html"));
    }

    @Test
    void testUpload() throws Exception {
        // Given
        var form = CreateDocumentForm.builder().build();
        // When
        var result = mockMvc.perform(
                MockMvcRequestBuilders.multipart("/documents/upload")
                        .file(new MockMultipartFile("test.pdf", new byte[]{}))
        );
        // Then
        result.andExpect(MockMvcResultMatchers.status().is3xxRedirection());
        result.andExpect(MockMvcResultMatchers.redirectedUrl("/documents"));
        Mockito.verify(documentService, Mockito.times(1)).upload(form);
    }
}