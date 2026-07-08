package com.merchant.merchantonboarding.kafka;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MerchantCreatedEvent {

    private Long merchantId;

    private String businessName;

    private String email;

    private String status;
}
