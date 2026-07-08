package com.merchant.merchantonboarding.dto;

import lombok.Data;

@Data
public class DocumentResponse {

    private Long id;

    private Long merchantId;

    private String documentType;

    private String fileName;

    private String filePath;
}