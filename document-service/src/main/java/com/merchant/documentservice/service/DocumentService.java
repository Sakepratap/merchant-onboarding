package com.merchant.documentservice.service;

import com.merchant.documentservice.entity.Document;
import com.merchant.documentservice.repository.DocumentRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class DocumentService {

    private final DocumentRepository repository;

    public DocumentService(DocumentRepository repository) {
        this.repository = repository;
    }

    public Document uploadDocument(
            Long merchantId,
            String documentType,
            MultipartFile file) throws Exception {

        String uploadDir = "uploads/";

        Files.createDirectories(Paths.get(uploadDir));

        String filePath =
                uploadDir + file.getOriginalFilename();

        Path path = Paths.get(filePath);

        Files.write(path, file.getBytes());

        Document document =
                Document.builder()
                        .merchantId(merchantId)
                        .documentType(documentType)
                        .fileName(file.getOriginalFilename())
                        .filePath(filePath)
                        .uploadedAt(LocalDateTime.now())
                        .build();

        return repository.save(document);
    }
    public List<Document> getDocumentsByMerchantId(
            Long merchantId) {

        return repository.findByMerchantId(
                merchantId);
    }
}