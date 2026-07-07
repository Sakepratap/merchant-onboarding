package com.merchant.merchantonboarding.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class MerchantProducer {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public MerchantProducer(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void publishMerchantCreatedEvent(
            MerchantCreatedEvent event) {

        kafkaTemplate.send(
                "merchant-created-topic",
                event);

        System.out.println(
                "Merchant Event Published : " + event);
    }
}