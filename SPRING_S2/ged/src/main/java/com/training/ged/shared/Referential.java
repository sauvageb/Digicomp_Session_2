package com.training.ged.shared;

import com.training.ged.domain.model.DocumentType;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class Referential {

    public List<DocumentType> getDocumentTypes(){
        return Arrays.stream(DocumentType.values()).toList();
    }
}
