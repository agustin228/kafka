package org.binar.kafkaservice.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaProducer {
    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;
    @Value("${spring.kafka.topic}")
    private String kafkaTopic;


    public void sendKafkaTopic(String message) {
        kafkaTemplate.send(kafkaTopic, message);
    }
}
