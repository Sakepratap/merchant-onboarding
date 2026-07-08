package com.merchant.notificationservice.kafka;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MerchantApprovedEvent {

    private Long merchantId;
    private String businessName;
    private String status;
}