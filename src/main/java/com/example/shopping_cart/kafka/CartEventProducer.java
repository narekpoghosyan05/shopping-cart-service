package com.example.shopping_cart.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class CartEventProducer {
    private final KafkaTemplate<String, String> kafkaTemplate;

    public CartEventProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendItemAddedEvent(String message) {
        kafkaTemplate.send("cart-events", message);
    }
}
