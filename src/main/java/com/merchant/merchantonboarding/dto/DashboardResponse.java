package com.merchant.merchantonboarding.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DashboardResponse {

    private Long totalMerchants;
    private Long pendingMerchants;
    private Long approvedMerchants;
    private Long rejectedMerchants;
}