package com.merchant.merchantonboarding.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MerchantResponse {

    private Long merchantId;
    private String businessName;
    private String ownerName;
    private String email;
    private String phone;
    private String businessType;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}