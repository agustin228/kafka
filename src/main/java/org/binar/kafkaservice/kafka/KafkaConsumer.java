package org.binar.kafkaservice.kafka;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;


import java.util.ArrayList;
import java.util.List;


@Component
public class KafkaConsumer {

    @Value("${spring.kafka.topic}")
    private String topicName;

    private final List<String> messages = new ArrayList<>();

    @KafkaListener(topics = "topic-post", groupId = "post-1")
    public void listenTopic(String message) {
        synchronized (messages) {
            messages.add(message);
        }
    }
    public List<String> getMessages() {
        return messages;
    }
}

