package com.merchant.merchantonboarding.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class MerchantConsumer {

    @KafkaListener(
            topics = "merchant-created-topic",
            groupId = "merchant-created-group")
    public void consume(
            MerchantCreatedEvent event) {

        System.out.println(
                "Merchant Event Consumed : "
                        + event);
    }
    @KafkaListener(
            topics = "merchant-approved-topic",
            groupId = "merchant-approved-group")
    public void consumeApproved(
            MerchantApprovedEvent event) {

        System.out.println(
                "Merchant Approved Event Consumed : "
                        + event);
    }
}