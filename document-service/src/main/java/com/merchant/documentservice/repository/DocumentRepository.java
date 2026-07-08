package com.merchant.documentservice.repository;

import com.merchant.documentservice.entity.Document;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DocumentRepository
        extends JpaRepository<Document, Long> {

    List<Document> findByMerchantId(Long merchantId);
}