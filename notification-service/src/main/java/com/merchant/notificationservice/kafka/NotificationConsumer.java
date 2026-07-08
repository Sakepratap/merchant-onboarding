package com.merchant.notificationservice.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationConsumer {

    @KafkaListener(
            topics = "merchant-created-topic",
            groupId = "notification-group")
    public void consumeCreated(String message) {

        System.out.println(
                "EMAIL SENT : Merchant Created -> "
                        + message);
    }

    @KafkaListener(
            topics = "merchant-approved-topic",
            groupId = "notification-group")
    public void consumeApproved(String message) {

        System.out.println(
                "EMAIL SENT : Merchant Approved -> "
                        + message);
    }
}