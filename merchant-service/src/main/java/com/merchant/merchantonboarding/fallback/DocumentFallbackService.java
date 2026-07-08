package com.merchant.merchantonboarding.fallback;

import com.merchant.merchantonboarding.dto.DocumentResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DocumentFallbackService {

    public List<DocumentResponse> getDocumentsFallback(
            Long merchantId,
            Exception ex) {

        System.out.println(
                "Document Service Down. Fallback Triggered.");

        return List.of();
    }
}