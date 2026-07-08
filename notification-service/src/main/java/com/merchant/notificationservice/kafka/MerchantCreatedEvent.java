package com.merchant.notificationservice.kafka;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MerchantCreatedEvent {

    private Long merchantId;
    private String businessName;
    private String email;
    private String status;
}