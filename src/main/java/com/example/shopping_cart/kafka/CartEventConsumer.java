package com.example.shopping_cart.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class CartEventConsumer {

    @KafkaListener(topics = "cart-created", groupId = "cart-group")
    public void consume(String message) {
        // Here you can convert the message to a DTO or entity if needed
        System.out.println("Received message from cart-created topic: " + message);
    }
}
