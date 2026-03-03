package com.example.shopping_cart.integration;

import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.kafka.KafkaContainer;

@Testcontainers
@SpringBootTest
class CartIntegrationTest {

    @Container
    static KafkaContainer kafka =
            new KafkaContainer("apache/kafka:latest");

}
