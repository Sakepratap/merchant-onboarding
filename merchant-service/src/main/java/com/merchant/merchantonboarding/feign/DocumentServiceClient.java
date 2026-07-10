package com.merchant.merchantonboarding.feign;

import com.merchant.merchantonboarding.dto.DocumentResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(
        name = "DOCUMENT-SERVICE",
        url = "http://localhost:8084"
)
public interface DocumentServiceClient {

    @GetMapping("/api/documents/{merchantId}")
    List<DocumentResponse> getDocuments(
            @PathVariable Long merchantId);
}