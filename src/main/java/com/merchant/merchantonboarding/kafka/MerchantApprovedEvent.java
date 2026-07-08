package com.merchant.merchantonboarding.kafka;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MerchantApprovedEvent {

    private Long merchantId;

    private String businessName;

    private String status;
}