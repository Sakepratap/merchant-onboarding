package com.merchant.documentservice.controller;

import com.merchant.documentservice.entity.Document;
import com.merchant.documentservice.service.DocumentService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.http.MediaType;

import java.util.List;

@RestController
@RequestMapping("/api/documents")
public class DocumentController {

    private final DocumentService service;

    public DocumentController(DocumentService service) {
        this.service = service;
    }


    @PostMapping(
            value = "/upload",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Document uploadDocument(

            @RequestParam Long merchantId,

            @RequestParam String documentType,

            @Parameter(description = "Document file")
            @RequestParam("file") MultipartFile file)

            throws Exception {

        return service.uploadDocument(
                merchantId,
                documentType,
                file);
    }
    @GetMapping("/{merchantId}")
    public List<Document> getDocuments(
            @PathVariable Long merchantId) {

        return service.getDocumentsByMerchantId(
                merchantId);
    }
}