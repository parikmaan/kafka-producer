package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class EmployeeProducer {
    private final String kafkaTopic;
    private final KafkaTemplate<String, String> kafkaTemplate;

    public EmployeeProducer(
            @Value("${spring.kafka.template.default-topic}") String kafkaTopic,
            KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTopic = kafkaTopic;
        this.kafkaTemplate = kafkaTemplate;
    }

    public void produceMessages() {
        for(int i = 0; i < 250000; i++) {
            this.kafkaTemplate
                    .send(kafkaTopic, new Employee("Dummy first name", "Dummy last name").toString())
                    .whenComplete((stringStringSendResult, throwable) -> {
                        if (throwable == null) {
                            System.out.println("Message produced successfully.");
                        } else {
                            System.out.println("Error producing message!");
                        }
                    });
        }
    }
}
